package com.chuby.savings.db

import android.support.test.runner.AndroidJUnit4
import com.chuby.savings.utils.DbTestUtil
import com.chuby.savings.utils.LiveDataTestUtil
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by developer on 29/03/18.
 */
@RunWith(AndroidJUnit4::class)
class AccountDaoTest : DbTest() {

    @Test
    @Throws(InterruptedException::class)
    fun emptyAccounts() {
        val accounts = LiveDataTestUtil.getValue(accountDao.getAccounts())

        verifyValue(accounts.size, 0)
        verifyValue(accounts.isEmpty(), true)
    }

    @Test
    fun insertAccount() {
        userDao.insert(DbTestUtil.getFirstUser())

        val account = DbTestUtil.getCaymanAccount()
        val rowId = accountDao.insert(account)

        verifyValue(rowId, 1L)
    }

    @Test
    fun insertAccounts() {
        userDao.insert(DbTestUtil.getUsers())

        val accounts = DbTestUtil.getAccounts()
        val rowId = accountDao.insert(accounts)

        verifyValue(rowId, listOf(1L, 2L, 3L, 4L, 5L, 6L, 7L))
    }

    @Test
    @Throws(InterruptedException::class)
    fun updateAccount() {
        userDao.insert(DbTestUtil.getFirstUser())
        accountDao.insert(DbTestUtil.getCaymanAccount())

        val account = LiveDataTestUtil.getValue(accountDao.getAccount(1))
        account.amount = 23.11

        val updatedRows = accountDao.update(account)

        verifyValue(updatedRows, 1)

        val updatedAccount = LiveDataTestUtil.getValue(accountDao.getAccounts())[0]

        verifyValue(updatedAccount.amount, 23.11)
    }

    @Test
    @Throws(InterruptedException::class)
    fun insertAccountsAndReadByUserId() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())
        movementDao.insert(DbTestUtil.getMovements())

        val firstUserAccounts = LiveDataTestUtil.getValue(accountDao.getAccountsForUser(1))

        verifyValue(firstUserAccounts.size, 3)

        val secondUserAccounts = LiveDataTestUtil.getValue(accountDao.getAccountsForUser(2))

        verifyValue(secondUserAccounts.size, 1)
    }

    @Test
    @Throws(InterruptedException::class)
    fun updateAccounts() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())

        val firstAccount = LiveDataTestUtil.getValue(accountDao.getAccounts())[0]
        val secondAccount = LiveDataTestUtil.getValue(accountDao.getAccounts())[1]

        firstAccount.name = "Not so secret anymore"
        secondAccount.amount = 0.0

        val updatedRows = accountDao.update(listOf(firstAccount, secondAccount))

        verifyValue(updatedRows, 2)

        val updatedAccounts = LiveDataTestUtil.getValue(accountDao.getAccounts())

        verifyValue(updatedAccounts[0].name, "Not so secret anymore")
        verifyValue(updatedAccounts[1].amount, 0.0)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteAccount() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())

        val accounts = LiveDataTestUtil.getValue(accountDao.getAccounts())

        verifyValue(accounts.size, 7)

        val deletedRows = accountDao.delete(accounts[1])

        verifyValue(deletedRows, 1)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteAccounts() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())

        val accounts = LiveDataTestUtil.getValue(accountDao.getAccounts())

        val deletedRows = accountDao.delete(accounts)

        verifyValue(deletedRows, 7)
        verifyValue(LiveDataTestUtil.getValue(accountDao.getAccounts()).isEmpty(), true)
    }
}