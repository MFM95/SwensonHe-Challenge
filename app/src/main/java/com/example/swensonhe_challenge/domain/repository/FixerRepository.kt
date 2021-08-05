package com.example.swensonhe_challenge.domain.repository

import com.example.swensonhe_challenge.data.model.LatestRatesResponse

import retrofit2.Response

interface FixerRepository {
    suspend fun getLatestRates(accessKey: String, base: String): Response<LatestRatesResponse>
}