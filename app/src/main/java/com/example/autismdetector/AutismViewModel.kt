package com.example.autismdetector

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AutismViewModel : ViewModel() {

    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int> get() = _age

    private val _gender = MutableLiveData<String>()
    val gender: LiveData<String> get() = _gender

    private val _ethnicity = MutableLiveData<String>()
    val ethnicity: LiveData<String> get() = _ethnicity

    private val _jaundice = MutableLiveData<String>()
    val jaundice: LiveData<String> get() = _jaundice

    private val _autism = MutableLiveData<String>()
    val autism: LiveData<String> get() = _autism

    private val _country = MutableLiveData<String>()
    val country: LiveData<String> get() = _country

    private val _app = MutableLiveData<String>()
    val app: LiveData<String> get() = _app

    private val _relation = MutableLiveData<String>()
    val relation: LiveData<String> get() = _relation

    fun setAge(value: Int) { _age.value = value }
    fun setGender(value: String) { _gender.value = value }
    fun setEthnicity(value: String) { _ethnicity.value = value }
    fun setJaundice(value: String) { _jaundice.value = value }
    fun setAutism(value: String) { _autism.value = value }
    fun setCountry(value: String) { _country.value = value }
    fun setApp(value: String) { _app.value = value }
    fun setRelation(value: String) { _relation.value = value }
}

