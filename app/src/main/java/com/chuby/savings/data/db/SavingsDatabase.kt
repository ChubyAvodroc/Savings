package com.chuby.savings.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.chuby.savings.data.db.dao.AccountDao
import com.chuby.savings.data.db.dao.MovementDao
import com.chuby.savings.data.db.dao.UserDao
import com.chuby.savings.data.db.entities.Account
import com.chuby.savings.data.db.entities.Movement
import com.chuby.savings.data.db.entities.User

/**
 * Created by developer on 29/03/18.
 */
@Database(entities = [Account::class, Movement::class, User::class], version = 1)
abstract class SavingsDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun movementDao(): MovementDao

    abstract fun userDao(): UserDao
}