package com.chuby.savings.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by developer on 28/03/18.
 */
@Entity(
    tableName = "movements",
    foreignKeys = [ForeignKey(
        entity = Account::class,
        parentColumns = ["id"],
        childColumns = ["account_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
class Movement(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "ammount") var ammount: Double,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "account_id") var accountId: Int
)