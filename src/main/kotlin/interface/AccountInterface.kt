package `interface`

import domain.model.Account
import application.service.AccountUsecase
import infrastructure.repository.InMemoryAccountRepository

class AccountInterface {
    fun openAccount(): AccountResponse {
        val usecase = AccountUsecase(InMemoryAccountRepository())
        val newAccount = usecase.openAccount()
        return AccountResponse(id = newAccount.id, balance = newAccount.balance)
    }

    fun deposit(id: String, amount: Int): AccountResponse {
        val usecase = AccountUsecase(InMemoryAccountRepository())
        val account = usecase.deposit(id, amount)
        return AccountResponse(id = account.id, balance = account.balance)
    }

    fun withdraw(id: String, amount: Int): AccountResponse {
        val usecase = AccountUsecase(InMemoryAccountRepository())
        val account = usecase.withdraw(id, amount)
        return AccountResponse(id = account.id, balance = account.balance)
    }

    fun closeAccount(id: String): AccountResponse {
        val usecase = AccountUsecase(InMemoryAccountRepository())
        val account = usecase.closeAccount(id)
        return AccountResponse(id = account.id, balance = account.balance)
    }

    fun checkBalance(id: String): AccountResponse {
        val usecase = AccountUsecase(InMemoryAccountRepository())
        val account = usecase.checkBalance(id)
        return AccountResponse(id = account.id, balance = account.balance)
    }

}