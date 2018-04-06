package com.chuby.savings.data.db.entities

import android.arch.persistence.room.*

/**
 * Created by developer on 28/03/18.
 */
@Entity(
    tableName = "Accounts",
    indices = [(Index(name = "userId", value = arrayOf("user_id")))],
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["user_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
class Account(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "amount") var amount: Double,
    @ColumnInfo(name = "user_id") var userId: Int
)