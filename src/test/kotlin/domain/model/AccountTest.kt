package domain.model

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AccountTest {

    @Test
    fun testClose() {
        val account = Account("123", 100)
        account.close()
    }

    @Test
    fun testShowBalance() {
        val account = Account("123", 100)
        account.showBalance()
    }

    @Test
    fun testDeposit() {
        // original balance is 100. deposit 100, result should be 200
        val account = Account("123", 100)
        account.deposit(100)
        assertEquals(200, account.showBalance())
    }

    @Test
    fun testWithdraw() {
        val account = Account("123", 100)
        account.withdraw(100)
        assertEquals(0, account.showBalance())
    }
}