package com.example.swensonhe_challenge.data.model

data class LatestRatesResponse(
    val base: String,
    val date: String,
    val error: Error,
    val rates: LinkedHashMap<String, Double>,
    val success: Boolean,
    val timestamp: Int
)