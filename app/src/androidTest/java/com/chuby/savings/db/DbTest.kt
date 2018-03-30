package com.chuby.savings.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.chuby.savings.data.db.SavingsDatabase
import org.junit.After
import org.junit.Before

/**
 * Created by developer on 29/03/18.
 */
abstract class DbTest {
    protected lateinit var db: SavingsDatabase

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getTargetContext(),
            SavingsDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() = db.close()
}