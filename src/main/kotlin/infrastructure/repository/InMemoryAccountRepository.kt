package infrastructure.repository

import domain.model.Account
import domain.repository.AccountRepository

class AccountNotFoundException : RuntimeException("Account not found")

class InMemoryAccountRepository : AccountRepository {

    private val accounts: MutableMap<String, Account> = mutableMapOf()

    override fun save(account: Account) {
        accounts[account.id] = account
    }

    override fun findById(id: String): Account {
        print("findById: $id, and accounts: $accounts")
        return accounts[id] ?: throw AccountNotFoundException()
    }

    override fun update(account: Account) {
        accounts[account.id]?.let {
            accounts[account.id] = account
        } ?: throw AccountNotFoundException()
    }

    override fun delete(account: Account) {
        if (accounts.containsKey(account.id)) {
            accounts.remove(account.id)
        } else {
            throw AccountNotFoundException()
        }
    }

}
