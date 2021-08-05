package com.example.swensonhe_challenge.data.repository

import com.example.swensonhe_challenge.data.model.LatestRatesResponse
import com.example.swensonhe_challenge.data.source.remote.FixerAPIService
import com.example.swensonhe_challenge.domain.repository.FixerRepository
import retrofit2.Response
import javax.inject.Inject

class FixerRepositoryImpl @Inject constructor(private val fixerAPIService: FixerAPIService) :
    FixerRepository {
    override suspend fun getLatestRates(accessKey: String, base: String): Response<LatestRatesResponse> {
        return fixerAPIService.getLatestRates(accessKey, base)
    }
}