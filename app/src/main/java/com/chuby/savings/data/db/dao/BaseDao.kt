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
    fun insert(entity: Type): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insert(entities: List<Type>): List<Long>

    @Update
    fun update(entity: Type)

    @Update
    @JvmSuppressWildcards
    fun update(entities: List<Type>)

    @Delete
    fun delete(entity: Type)

    @Delete
    @JvmSuppressWildcards
    fun delete(entities: List<Type>)
}