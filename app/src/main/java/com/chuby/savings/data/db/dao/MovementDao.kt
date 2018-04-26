package com.chuby.savings.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.chuby.savings.data.db.entities.Movement

/**
 * Created by developer on 29/03/18.
 */
@Dao
interface MovementDao : BaseDao<Movement> {

    @Query("DELETE FROM Movements WHERE id = :movementId")
    fun delete(movementId: Int): Int

    @Query("SELECT * FROM Movements")
    fun getMovements(): LiveData<List<Movement>>

    @Query("SELECT * FROM Movements WHERE account_id = :accountId")
    fun getMovementsForAccount(accountId: Int): LiveData<List<Movement>>
}