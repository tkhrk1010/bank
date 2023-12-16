package application.service

import domain.model.Account
import domain.repository.AccountRepository
import java.util.UUID

class AccountUsecase(private val repo: AccountRepository) {

    fun openAccount(initialDeposit: Int): Account {
        require(initialDeposit >= 0) { "Initial deposit must be positive" }
        val newAccount = Account(id = generateUUID(), balance = initialDeposit)
        repo.save(newAccount)
        return newAccount
    }

    fun checkBalance(id: String): Int {
        val account = repo.findById(id)
        if (account == null) {
            throw RuntimeException("Account not found")
        }
        return account.balance
    }

    fun deposit(id: String, amount: Int): Account {
        val account = repo.findById(id) ?: throw RuntimeException("Account not found")
        require(amount > 0) { "Invalid deposit amount" }
        account.deposit(amount)
        repo.update(account)
        return account
    }

    fun withdraw(id: String, amount: Int): Account {
        val account = repo.findById(id) ?: throw RuntimeException("Account not found")
        require(account.balance >= amount) { "Insufficient funds" }
        account.withdraw(amount)
        repo.update(account)
        return account
    }

    fun closeAccount(id: String) {
        val account = repo.findById(id) ?: throw RuntimeException("Account not found")
        repo.delete(account)
    }

    private
    fun generateUUID(): String {
        return UUID.randomUUID().toString()
    }
}
