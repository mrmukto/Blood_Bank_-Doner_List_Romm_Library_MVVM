package com.mrmukto.bloodbank.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_blood")
data class BloodModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "donor_id")
    var bloodId: Long = 0,
    @ColumnInfo(name = "name")
    val name: String,
    val age: String,
    val phone: String,
    val gender: String,
    val bloodRGroup: String,
    var date: Long = System.currentTimeMillis(),
    var day: Int,
    var month: Int,
    var year: Int,
)
