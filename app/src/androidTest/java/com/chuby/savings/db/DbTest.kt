package com.chuby.savings.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.chuby.savings.data.db.SavingsDatabase
import com.chuby.savings.data.db.dao.AccountDao
import com.chuby.savings.data.db.dao.MovementDao
import com.chuby.savings.data.db.dao.UserDao
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before

/**
 * Created by developer on 29/03/18.
 */
abstract class DbTest {
    private lateinit var db: SavingsDatabase
    protected val accountDao: AccountDao by lazy {
        db.accountDao()
    }
    protected val movementDao: MovementDao by lazy {
        db.movementDao()
    }
    protected val userDao: UserDao by lazy {
        db.userDao()
    }

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getTargetContext(),
            SavingsDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() = db.close()

    protected fun <Type> verifyValue(value: Type, expected: Type) {
        MatcherAssert.assertThat(value, CoreMatchers.`is`(expected))
    }
}