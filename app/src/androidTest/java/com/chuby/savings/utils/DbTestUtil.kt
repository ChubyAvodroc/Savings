package com.chuby.savings.utils

import com.chuby.savings.data.db.entities.Account
import com.chuby.savings.data.db.entities.Address
import com.chuby.savings.data.db.entities.Movement
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

    private fun getThirdUserAddress(): Address = Address(
        "False Street 654",
        "False Sate 768",
        "False City 956",
        83746
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

    fun getThirdUser(): User = User(
        name = "ThirdUser",
        lastname = "NotReal",
        surname = "Dummy",
        address = getThirdUserAddress()
    )

    fun getUsers(): List<User> = listOf(getFirstUser(), getSecondUser(), getThirdUser())

    fun getCaymanAccount(): Account = Account(
        name = "Cayman Secret Account",
        amount = 12_100_309.00,
        userId = 1
    )

    fun getVeniceAccount(): Account = Account(
        name = "Venice Secret Account",
        amount = 23_417_432.34,
        userId = 1
    )

    fun getRussianAccount(): Account = Account(
        name = "Russian Secret Account",
        amount = 65_349.67,
        userId = 1
    )

    fun getSchweizAccount(): Account = Account(
        name = "Schweiz Not Secret Account",
        amount = 1_621_092_423.08,
        userId = 2
    )

    fun getAfricanAccount(): Account = Account(
        name = "African Account",
        amount = 1_621_092_423.27,
        userId = 3
    )

    fun getIndianAccount(): Account = Account(
        name = "Indian Account",
        amount = 5_362_748_929_371.00,
        userId = 3
    )

    fun getIrelandAccount(): Account = Account(
        name = "Ireland Account",
        amount = 2_749_238_749.82,
        userId = 3
    )

    fun getAccounts() = listOf(
        getCaymanAccount(),
        getVeniceAccount(),
        getRussianAccount(),
        getSchweizAccount(),
        getAfricanAccount(),
        getIndianAccount(),
        getIrelandAccount()
    )

    fun getFoodMovement(accountId: Int): Movement = Movement(
        name = "Buy food",
        ammount = 650.53,
        date = "16/04/2018",
        accountId = accountId
    )

    fun getGymMovement(accountId: Int): Movement = Movement(
        name = "Gym",
        ammount = 1500.0,
        date = "01/10/2018",
        accountId = accountId
    )

    fun getMoviesMovement(accountId: Int): Movement = Movement(
        name = "Movies",
        ammount = 150.34,
        date = "04/05/2018",
        accountId = accountId
    )

    fun getCCPaymentMovement(accountId: Int): Movement = Movement(
        name = "Credit card payment",
        ammount = 1447.73,
        date = "29/01/2018",
        accountId = accountId
    )

    fun getDCWithdrawalMovement(accountId: Int): Movement = Movement(
        name = "Debit card withdrawal",
        ammount = 350.0,
        date = "11/07/2018",
        accountId = accountId
    )

    fun getGoogleIOTicketMovement(accountId: Int): Movement = Movement(
        name = "Google IO ticket",
        ammount = 1150.0,
        date = "27/02/2018",
        accountId = accountId
    )

    fun getAADCertMovement(accountId: Int): Movement = Movement(
        name = "Associate Android Developer cert exam",
        ammount = 160.0,
        date = "23/05/2018",
        accountId = accountId
    )

    fun getSCRUMCourseMovement(accountId: Int): Movement = Movement(
        name = "SCRUM master course",
        ammount = 11_203.0,
        date = "05/11/2018",
        accountId = accountId
    )

    fun getClosetMovement(accountId: Int): Movement = Movement(
        name = "Semillas y Girasoles",
        ammount = 4500.0,
        date = "16/12/2018",
        accountId = accountId
    )

    fun getFirstAccountMovements(): List<Movement> = listOf(
        getFoodMovement(1),
        getGymMovement(1),
        getMoviesMovement(1),
        getCCPaymentMovement(1),
        getDCWithdrawalMovement(1)
    ) // $4098.6

    fun getSecondAccountMovements(): List<Movement> = listOf(
        getGoogleIOTicketMovement(2),
        getAADCertMovement(2),
        getSCRUMCourseMovement(2),
        getClosetMovement(2)
    ) // $17_013

    fun getMovements(): List<Movement> = listOf(
        getFoodMovement(1),
        getGymMovement(1),
        getMoviesMovement(1),
        getCCPaymentMovement(1),
        getDCWithdrawalMovement(1),
        getGoogleIOTicketMovement(2),
        getAADCertMovement(2),
        getSCRUMCourseMovement(2),
        getClosetMovement(2)
    )
}