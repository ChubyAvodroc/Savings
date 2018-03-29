package com.chuby.savings.data.db.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

/**
 * Created by developer on 29/03/18.
 */
interface BaseDao<in Type> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: Type)

    @Update
    fun update(entity: Type)

    @Delete
    fun delete(entity: Type)
}