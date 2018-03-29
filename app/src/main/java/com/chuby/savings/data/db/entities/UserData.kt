package com.chuby.savings.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by developer on 29/03/18.
 */
@Entity(tableName = "Users")
class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "lastname") var lastname: String,
    @ColumnInfo(name = "surname") var surname: String,
    @Embedded var address: Address
)

class Address(
    @ColumnInfo(name = "street") var street: String,
    @ColumnInfo(name = "state") var state: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "post_code") var postCode: Int
)

