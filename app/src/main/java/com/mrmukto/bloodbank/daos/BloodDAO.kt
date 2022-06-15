package com.mrmukto.bloodbank.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mrmukto.bloodbank.entities.BloodModel

@Dao
interface BloodDAO {
    @Insert
    suspend fun insertDonor(bloodModel: BloodModel)

    @Update
    suspend fun updateDonor(bloodModel: BloodModel)

    @Delete
    suspend fun deleteDonor(bloodModel: BloodModel)

    @Query("select * from tbl_blood")
    fun getDonorList() : LiveData<List<BloodModel>>
}