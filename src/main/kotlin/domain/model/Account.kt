package domain.model


class Account(
    var id: String,
    var balance: Int,
    var IsAvailable: Boolean = true
) {

    fun close() {
        IsAvailable = false
    }

    fun showBalance(): Int {
        return balance
    }

    fun deposit(amount: Int) {
        balance += amount
    }

    fun withdraw(amount: Int) {
        balance -= amount
    }

}