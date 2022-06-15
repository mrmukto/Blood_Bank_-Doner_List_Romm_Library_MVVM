package com.mrmukto.bloodbank.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mrmukto.bloodbank.db.BloodDatabase
import com.mrmukto.bloodbank.entities.BloodModel
import com.mrmukto.bloodbank.repos.BloodRepo
import kotlinx.coroutines.launch

class BloodViewModel(application: Application) : AndroidViewModel(application){

    private val bloodDao = BloodDatabase.getDB(application).bloodDao()
    private val repository = BloodRepo(bloodDao)
    var donorList = listOf<BloodModel>()
    fun insertDonor(bloodModel: BloodModel) {
        viewModelScope.launch {
            repository.insertDonor(bloodModel)
        }
    }

    fun getDonorList() = repository.getDonorList()


    fun updateTodo(bloodModel: BloodModel) {
        viewModelScope.launch {
            repository.updateTodo(bloodModel)
        }
    }

    fun deleteTodo(bloodModel: BloodModel) {
        viewModelScope.launch {
            repository.deleteTodo(bloodModel)
        }
    }


}