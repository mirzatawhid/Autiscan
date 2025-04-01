package com.example.autismdetector

import com.example.autismdetector.model.ASDRequest
import com.example.autismdetector.model.ASDResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/predict")
    fun predictASD(@Body request: ASDRequest): Call<ASDResponse>
}