package com.chuby.savings.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by developer on 29/03/18.
 */
@Entity(tableName = "users")
class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "lastname") var lastname: String,
    @ColumnInfo(name = "surname") var surname: String
)

