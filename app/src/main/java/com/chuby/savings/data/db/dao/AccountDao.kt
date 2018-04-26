package com.chuby.savings.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.chuby.savings.data.db.entities.Account

/**
 * Created by developer on 29/03/18.
 */
@Dao
interface AccountDao : BaseDao<Account> {

    @Query("DELETE FROM Accounts WHERE id = :accountId")
    fun delete(accountId: Int): Int

    @Query("SELECT * FROM Accounts")
    fun getAccounts(): LiveData<List<Account>>

    @Query("SELECT * FROM Accounts WHERE id = :accountId")
    fun getAccount(accountId: Int): LiveData<Account>

    @Query("SELECT * FROM Accounts WHERE user_id = :userId")
    fun getAccountsForUser(userId: Int): LiveData<List<Account>>
}