package com.mrmukto.bloodbank.repos

import com.mrmukto.bloodbank.daos.BloodDAO
import com.mrmukto.bloodbank.entities.BloodModel

class BloodRepo(val bloodDao: BloodDAO) {

    suspend fun insertDonor(bloodModel: BloodModel) {
        bloodDao.insertDonor(bloodModel)
    }

    fun getDonorList() = bloodDao.getDonorList()

    suspend fun updateTodo(bloodModel: BloodModel) = bloodDao.updateDonor(bloodModel)

    suspend fun deleteTodo(bloodModel: BloodModel) = bloodDao.deleteDonor(bloodModel)

}