package domain.repository

import domain.model.Account

interface AccountRepository {
    fun save(account: Account): Unit
    fun findById(id: String): Account?
    fun update(account: Account): Unit
    fun delete(account: Account): Unit
}
