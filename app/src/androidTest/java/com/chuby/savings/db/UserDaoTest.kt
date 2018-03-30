package com.chuby.savings.db

import android.support.test.runner.AndroidJUnit4
import com.chuby.savings.data.db.entities.Address
import com.chuby.savings.data.db.entities.User
import com.chuby.savings.utils.LiveDataTestUtil
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by developer on 29/03/18.
 */
@RunWith(AndroidJUnit4::class)
class UserDaoTest : DbTest() {

    private val firstAddress = Address(
        "False Street 123",
        "False State 456",
        "False City 789",
        12345
    )

    private val secondAddress = Address(
        "False Street 321",
        "False Sate 654",
        "False City 987",
        54321
    )

    private val firstUSer =
        User(
            name = "FirstUser",
            lastname = "Fake",
            surname = "Mock",
            address = firstAddress
        )

    private val secondUser = User(
        name = "SecondUser",
        lastname = "Mock",
        surname = "NotReal",
        address = secondAddress
    )

    @Test
    @Throws(InterruptedException::class)
    fun emptyUsers() {
        val users = LiveDataTestUtil.getValue(db.userDao().getUsers())
        verifyValue(users.isEmpty(), true)
    }

    @Test
    fun insertUser() {
        val rowId = db.userDao().insert(firstUSer)

        verifyValue(rowId, 1L)

        val insertedUser = LiveDataTestUtil.getValue(db.userDao().getUser(1))
        verifyValue(insertedUser.name, firstUSer.name)
    }

    @Test
    fun insertUsers() {
        val users = listOf(firstUSer, secondUser)
        val rowIds = db.userDao().insert(users)

        verifyValue(rowIds, listOf(1L, 2L))
    }

    @Test
    @Throws(InterruptedException::class)
    fun insertUsersAndRead() {
        val users = listOf(firstUSer, secondUser)
        db.userDao().insert(users)

        val usersLoaded = LiveDataTestUtil.getValue(db.userDao().getUsers())

        verifyValue(usersLoaded.size, 2)

        // first user
        val firstUser = usersLoaded[0]
        verifyValue(firstUser.name, "FirstUser")
        verifyValue(firstUser.address.street, "False Street 123")

        // second user
        val secondUser = usersLoaded[1]
        verifyValue(secondUser.name, "SecondUser")
        verifyValue(secondUser.address.street, "False Street 321")
    }

    @Test
    @Throws(InterruptedException::class)
    fun updateUserAndVerify() {
        db.userDao().insert(firstUSer)

        val usersLoaded = LiveDataTestUtil.getValue(db.userDao().getUsers())

        // first user
        val firstUser = usersLoaded[0]
        firstUser.name = "AnotherUser"

        val updatedRows = db.userDao().update(firstUser)
        verifyValue(updatedRows, 1)

        verifyValue(firstUser.name, "AnotherUser")

    }

    @Test
    @Throws(InterruptedException::class)
    fun updateUsersAndVerify() {
        db.userDao().insert(firstUSer)
        db.userDao().insert(secondUser)

        val usersLoaded = LiveDataTestUtil.getValue(db.userDao().getUsers())

        // first user
        val firstUser = usersLoaded[0]
        firstUser.name = "AnotherUser"

        val secondUser = usersLoaded[1]
        secondUser.name = "OneMoreUser"

        val updatedRows = db.userDao().update(listOf(firstUser, secondUser))

        verifyValue(updatedRows, 2)
        verifyValue(firstUser.name, "AnotherUser")
        verifyValue(secondUser.name, "OneMoreUser")

    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteUserAndVerify() {
        db.userDao().insert(listOf(firstUSer, secondUser))

        val usersLoaded = LiveDataTestUtil.getValue(db.userDao().getUsers())

        // first user
        val firstUser = usersLoaded[0]

        val deletedRows = db.userDao().delete(firstUser)
        verifyValue(deletedRows, 1)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteUserByIdAndVerify() {
        db.userDao().insert(listOf(firstUSer, secondUser))

        val usersLoaded = LiveDataTestUtil.getValue(db.userDao().getUsers())

        // first user
        val firstUser = usersLoaded[0]

        val deletedRows = db.userDao().delete(firstUser.id)
        verifyValue(deletedRows, 1)

    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteUsersAndVerify() {
        db.userDao().insert(firstUSer)
        db.userDao().insert(secondUser)

        val usersLoaded = LiveDataTestUtil.getValue(db.userDao().getUsers())

        val deletedRows = db.userDao().delete(usersLoaded)

        verifyValue(deletedRows, 2)

    }

    private fun <Type> verifyValue(value: Type, expected: Type) {
        assertThat(value, `is`(expected))
    }

}