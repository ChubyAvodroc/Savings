package com.chuby.savings.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.chuby.savings.data.db.entities.User

/**
 * Created by developer on 29/03/18.
 */
@Dao
interface UserDao : BaseDao<User> {

    @Query("DELETE FROM Users WHERE id = :userId")
    fun delete(userId: Int)

    @Query("SELECT * FROM Users")
    fun getUsers(): LiveData<List<User>>
}