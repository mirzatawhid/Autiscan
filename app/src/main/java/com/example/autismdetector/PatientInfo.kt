package com.example.autismdetector

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PatientInfo(var age:Int,
                       var gender: String,var ethnicity:String,
                       var jaundice:String,var autism:String,
                       var country:String,var app:String,
                       var relation:String) : Parcelable
