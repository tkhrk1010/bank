import `interface`.AccountInterface

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val accountInterface = AccountInterface()
            try {
                var res = accountInterface.openAccount()
                println("Opened account with Id ${res.id}")

                val res2 = accountInterface.openAccount()
                println("Opened account with Id ${res2.id}")

                val res3 = accountInterface.deposit(res.id, 500)
                println("Deposited 500 into account with Id ${res3.id}; new balance is ${res3.balance}")

                val res4 = accountInterface.withdraw(res.id, 1500)
                println("Withdrew 1500 from account with Id ${res4.id}; new balance is ${res4.balance}")

                val res5 = accountInterface.closeAccount(res.id)
                println("Account with Id ${res5.id} was Closed")

                val res6 = accountInterface.checkBalance(res2.id)
                println("Balance of account with Id ${res6.id} is ${res6.balance}")

            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun hello(): String {
        return "Hello, World!"
    }
}