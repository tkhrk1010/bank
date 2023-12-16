package `interface`

import application.service.AccountUsecase
import infrastructure.repository.InMemoryAccountRepository

class AccountInterface {
    fun main() {
        val repo = InMemoryAccountRepository()
        val usecase = AccountUsecase(repo)

        try {
            var account = usecase.openAccount(1000)
            println("Opened account with Id ${account.id} and balance ${account.balance}")

            val account2 = usecase.openAccount(2000)
            println("Opened account with Id ${account2.id} and balance ${account2.balance}")

            account = usecase.deposit(account.id, 500)
            println("Deposited 500 into account with Id ${account.id}; new balance is ${account.balance}")

            account = usecase.withdraw(account.id, 1500)
            println("Withdrew 1500 from account with Id ${account.id}; new balance is ${account.balance}")

            usecase.closeAccount(account.id)
            println("Account with Id ${account.id} was Closed")

            val balance2 = usecase.checkBalance(account2.id)
            println("Balance of account with Id ${account2.id} is $balance2")

        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

}