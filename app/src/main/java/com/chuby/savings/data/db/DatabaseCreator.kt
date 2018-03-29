package com.chuby.savings.data.db

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by developer on 29/03/18.
 */
object DatabaseCreator {

    fun database(context: Context): SavingsDatabase {
        return Room.databaseBuilder(context, SavingsDatabase::class.java, "savinds-db").build()
    }
}