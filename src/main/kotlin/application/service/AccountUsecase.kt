package application.service

import domain.model.Account
import domain.repository.AccountRepository
import java.util.UUID

class AccountUsecase(private val repo: AccountRepository) {

    fun openAccount(): Account {
        val newAccount = Account(id = generateUUID(), balance = 0)
        repo.save(newAccount)
        return newAccount
    }

    fun checkBalance(id: String): Account {
        val account = repo.findById(id)
        return account
    }

    fun deposit(id: String, amount: Int): Account {
        val account = repo.findById(id)
        require(amount > 0) { "Invalid deposit amount" }
        account.deposit(amount)
        repo.update(account)
        return account
    }

    fun withdraw(id: String, amount: Int): Account {
        val account = repo.findById(id)
        require(account.balance >= amount) { "Insufficient funds" }
        account.withdraw(amount)
        repo.update(account)
        return account
    }

    fun closeAccount(id: String): Account {
        val account = repo.findById(id)
        repo.delete(account)
        return account
    }

    private
    fun generateUUID(): String {
        return UUID.randomUUID().toString()
    }
}
