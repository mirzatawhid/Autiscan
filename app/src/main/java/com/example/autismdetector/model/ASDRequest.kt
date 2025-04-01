package com.example.autismdetector.model

data class ASDRequest(
    val A1_Score: Int,
    val A2_Score: Int,
    val A3_Score: Int,
    val A4_Score: Int,
    val A5_Score: Int,
    val A6_Score: Int,
    val A7_Score: Int,
    val A8_Score: Int,
    val A9_Score: Int,
    val A10_Score: Int,
    val age: Int,
    val result: Int,
    val gender: String,
    val ethnicity: String,
    val jundice: String,
    val austim: String,
    val contry_of_res: String,
    val used_app_before: String,
    val relation: String
)

