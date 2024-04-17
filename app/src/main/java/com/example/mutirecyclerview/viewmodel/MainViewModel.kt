package com.example.mutirecyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mutirecyclerview.entity.AssembleEntity
import com.example.mutirecyclerview.repository.AssembleRepository

class MainViewModel: ViewModel() {

    private val repository = AssembleRepository()

    private val _assamble = MutableLiveData<List<AssembleEntity>>()

    val assamble : LiveData<List<AssembleEntity>> = _assamble

    fun getAllData() {
        _assamble.value = repository.getAll()
    }
}