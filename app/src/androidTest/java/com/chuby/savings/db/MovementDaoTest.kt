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
class MovementDaoTest : DbTest() {

    @Test
    @Throws(InterruptedException::class)
    fun emptyMovements() {
        val movements = LiveDataTestUtil.getValue(movementDao.getMovements())

        verifyValue(movements.size, 0)
        verifyValue(movements.isEmpty(), true)
    }

    @Test
    @Throws(InterruptedException::class)
    fun insertMovements() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())
        movementDao.insert(DbTestUtil.getMovements())

        val movements = LiveDataTestUtil.getValue(movementDao.getMovements())

        verifyValue(movements.size, 9)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteAllMovements() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())
        movementDao.insert(DbTestUtil.getMovements())

        val allMovements = LiveDataTestUtil.getValue(movementDao.getMovements())

        val deletedRows = movementDao.delete(allMovements)

        verifyValue(deletedRows, 9)
        verifyValue(LiveDataTestUtil.getValue(movementDao.getMovements()).isEmpty(), true)
    }

    @Test
    fun insertMovementsForFirstAccount() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())

        val movements = DbTestUtil.getFirstAccountMovements()
        val rowId = movementDao.insert(movements)

        verifyValue(rowId, listOf(1L, 2L, 3L, 4L, 5L))
    }

    @Test
    fun insertMovementsForSecondAccount() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())

        val movements = DbTestUtil.getSecondAccountMovements()
        val rowId = movementDao.insert(movements)

        verifyValue(rowId, listOf(1L, 2L, 3L, 4L))
    }

    @Test
    @Throws(InterruptedException::class)
    fun insertMovementsAndReadByAccountId() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())
        movementDao.insert(DbTestUtil.getMovements())

        val firstAccount = LiveDataTestUtil.getValue(accountDao.getAccounts())[0]

        val firstAccountMovements =
            LiveDataTestUtil.getValue(movementDao.getMovementsForAccount(firstAccount.id))

        val moviesMovement = firstAccountMovements[2]
        verifyValue(moviesMovement.name, "Movies")
        verifyValue(moviesMovement.ammount, 150.34)

        val withdrawalMovement = firstAccountMovements[4]
        verifyValue(withdrawalMovement.name, "Debit card withdrawal")
        verifyValue(withdrawalMovement.ammount, 350.0)

        val secondAccount = LiveDataTestUtil.getValue(accountDao.getAccounts())[1]

        val secondAccountMovements =
            LiveDataTestUtil.getValue(movementDao.getMovementsForAccount(secondAccount.id))

        val aadMovement = secondAccountMovements[1]
        verifyValue(aadMovement.date, "23/05/2018")
        verifyValue(aadMovement.accountId, 2)

        val closetMovement = secondAccountMovements[3]
        verifyValue(closetMovement.name, "Semillas y Girasoles")
        verifyValue(closetMovement.ammount, 4500.0)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteAccount() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())
        movementDao.insert(DbTestUtil.getMovements())

        val movements = LiveDataTestUtil.getValue(movementDao.getMovements())

        val googleIOMovement = movements[5]
        val gymMovement = movements[1]

        movementDao.delete(googleIOMovement)
        verifyValue(LiveDataTestUtil.getValue(movementDao.getMovements()).size, 8)
        movementDao.delete(gymMovement)
        verifyValue(LiveDataTestUtil.getValue(movementDao.getMovements()).size, 7)


    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteAccountDeletesItsMovements() {
        userDao.insert(DbTestUtil.getUsers())
        accountDao.insert(DbTestUtil.getAccounts())
        movementDao.insert(DbTestUtil.getMovements())

        val account = LiveDataTestUtil.getValue(accountDao.getAccounts())[0]
        accountDao.delete(account)

        val movements = LiveDataTestUtil.getValue(movementDao.getMovements())

        verifyValue(movements.size, 4)

    }
}