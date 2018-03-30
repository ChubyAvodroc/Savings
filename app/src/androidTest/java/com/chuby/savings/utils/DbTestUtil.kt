package com.chuby.savings.utils

import com.chuby.savings.data.db.entities.Address
import com.chuby.savings.data.db.entities.User

/**
 * Created by developer on 30/03/18.
 */
object DbTestUtil {

    private fun getFirstUserAddress(): Address = Address(
        "False Street 123",
        "False State 456",
        "False City 789",
        12345
    )

    private fun getSecondUserAddress(): Address = Address(
        "False Street 321",
        "False Sate 654",
        "False City 987",
        54321
    )

    fun getFirstUser(): User = User(
        name = "FirstUser",
        lastname = "Fake",
        surname = "Mock",
        address = getFirstUserAddress()
    )

    fun getSecondUser(): User = User(
        name = "SecondUser",
        lastname = "Mock",
        surname = "NotReal",
        address = getSecondUserAddress()
    )

    fun getUsers(): List<User> = listOf(getFirstUser(), getSecondUser())
}