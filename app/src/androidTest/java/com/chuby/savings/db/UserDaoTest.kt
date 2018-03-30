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
class UserDaoTest : DbTest() {

    @Test
    @Throws(InterruptedException::class)
    fun emptyUsers() {
        val users = LiveDataTestUtil.getValue(userDao.getUsers())

        verifyValue(users.isEmpty(), true)
    }

    @Test
    fun insertUser() {
        val user = DbTestUtil.getFirstUser()
        val rowId = userDao.insert(user)

        verifyValue(rowId, 1L)

        val insertedUser = LiveDataTestUtil.getValue(userDao.getUser(1))

        verifyValue(insertedUser.name, user.name)
    }

    @Test
    fun insertUsers() {
        val users = DbTestUtil.getUsers()
        val rowIds = userDao.insert(users)

        verifyValue(rowIds, listOf(1L, 2L))
    }

    @Test
    @Throws(InterruptedException::class)
    fun insertUsersAndRead() {
        val users = DbTestUtil.getUsers()

        userDao.insert(users)

        val usersLoaded = LiveDataTestUtil.getValue(userDao.getUsers())

        verifyValue(usersLoaded.size, 2)


        val firstUser = usersLoaded[0] // first user
        val secondUser = usersLoaded[1] // second user

        verifyValue(firstUser.name, "FirstUser")
        verifyValue(firstUser.address.street, "False Street 123")

        verifyValue(secondUser.name, "SecondUser")
        verifyValue(secondUser.address.street, "False Street 321")
    }

    @Test
    @Throws(InterruptedException::class)
    fun updateUserAndVerify() {
        val user = DbTestUtil.getFirstUser()

        userDao.insert(user)

        val usersLoaded = LiveDataTestUtil.getValue(userDao.getUsers())
        val firstUser = usersLoaded[0] // first user

        firstUser.name = "AnotherUser"

        val updatedRows = userDao.update(firstUser)

        verifyValue(updatedRows, 1)
        verifyValue(firstUser.name, "AnotherUser")
    }

    @Test
    @Throws(InterruptedException::class)
    fun updateUsersAndVerify() {
        userDao.insert(DbTestUtil.getFirstUser())
        userDao.insert(DbTestUtil.getSecondUser())

        val usersLoaded = LiveDataTestUtil.getValue(userDao.getUsers())
        val firstUser = usersLoaded[0] // first user
        val secondUser = usersLoaded[1] // second user

        firstUser.name = "AnotherUser"
        secondUser.name = "OneMoreUser"

        val updatedRows = userDao.update(listOf(firstUser, secondUser))

        verifyValue(updatedRows, 2)
        verifyValue(firstUser.name, "AnotherUser")
        verifyValue(secondUser.name, "OneMoreUser")

    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteUserAndVerify() {
        val users = DbTestUtil.getUsers()

        userDao.insert(users)

        val usersLoaded = LiveDataTestUtil.getValue(userDao.getUsers())
        val firstUser = usersLoaded[0] // first user
        val deletedRows = userDao.delete(firstUser)

        verifyValue(deletedRows, 1)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteUserByIdAndVerify() {
        val users = DbTestUtil.getUsers()

        userDao.insert(users)

        val usersLoaded = LiveDataTestUtil.getValue(userDao.getUsers())
        val firstUser = usersLoaded[0] // first user
        val deletedRows = userDao.delete(firstUser.id)

        verifyValue(deletedRows, 1)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteUsersAndVerify() {
        userDao.insert(DbTestUtil.getFirstUser())
        userDao.insert(DbTestUtil.getSecondUser())

        val usersLoaded = LiveDataTestUtil.getValue(userDao.getUsers())
        val deletedRows = userDao.delete(usersLoaded)

        verifyValue(deletedRows, 2)
    }
}