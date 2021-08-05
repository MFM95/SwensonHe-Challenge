package com.example.swensonhe_challenge.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.swensonhe_challenge.core.BaseResponse
import com.example.swensonhe_challenge.data.model.LatestRatesResponse
import com.example.swensonhe_challenge.domain.interactor.GetLatestRatesUseCase
import com.example.swensonhe_challenge.utils.NetworkErrorsHelper
import kotlinx.coroutines.*
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val getLatestRatesUseCase: GetLatestRatesUseCase
) :
    ViewModel() {

    val latestRatesResponse by lazy { MutableLiveData<BaseResponse>() }

    var job: Job? = null

    fun getLatestRates() {
        latestRatesResponse.value = BaseResponse.Loading(true)
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = getLatestRatesUseCase.getLatestRates()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            handleSuccessResponse(it)
                        }
                    } else {
                        response.message().let {
                            latestRatesResponse.postValue(
                                BaseResponse.Error(
                                    NetworkErrorsHelper.ErrorKind.UNEXPECTED,
                                    it
                                )
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                latestRatesResponse.postValue(
                    BaseResponse.Error(
                        NetworkErrorsHelper.ErrorKind.UNEXPECTED
                    )
                )
            }
        }
    }

    private fun handleSuccessResponse(responseBody: LatestRatesResponse) {
        if (responseBody.success) {
            latestRatesResponse.postValue(BaseResponse.Success(responseBody))
        } else {
            responseBody.error.let {
                var message = it.info
                if (message.isNullOrEmpty()) message = it.type
                latestRatesResponse.postValue(
                    BaseResponse.Error(
                        NetworkErrorsHelper.getErrorKind(it.code),
                        message
                    )
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}