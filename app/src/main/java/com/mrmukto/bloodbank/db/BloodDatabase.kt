package com.mrmukto.bloodbank.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.mrmukto.bloodbank.daos.BloodDAO
import com.mrmukto.bloodbank.entities.BloodModel

@Database(entities = [BloodModel::class], version = 1)
abstract class BloodDatabase : RoomDatabase() {
    abstract fun bloodDao() : BloodDAO

    companion object {
        private var db: BloodDatabase? = null
        fun getDB(context: Context): BloodDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    BloodDatabase::class.java,
                    "blood_db"
                ).build()
                return db!!
            }
            return db!!
        }

    }
}