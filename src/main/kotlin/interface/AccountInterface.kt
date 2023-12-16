package `interface`

import application.service.AccountUsecase

class AccountInterface(private val usecase: AccountUsecase) {
    fun openAccount(): AccountResponse {
        val newAccount = usecase.openAccount()
        return AccountResponse(id = newAccount.id, balance = newAccount.balance)
    }

    fun deposit(id: String, amount: Int): AccountResponse {
        val account = usecase.deposit(id, amount)
        return AccountResponse(id = account.id, balance = account.balance)
    }

    fun withdraw(id: String, amount: Int): AccountResponse {
        val account = usecase.withdraw(id, amount)
        return AccountResponse(id = account.id, balance = account.balance)
    }

    fun closeAccount(id: String): AccountResponse {
        val account = usecase.closeAccount(id)
        return AccountResponse(id = account.id, balance = account.balance)
    }

    fun checkBalance(id: String): AccountResponse {
        val account = usecase.checkBalance(id)
        return AccountResponse(id = account.id, balance = account.balance)
    }

}