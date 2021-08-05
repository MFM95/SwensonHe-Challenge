package com.example.swensonhe_challenge.core

import com.example.swensonhe_challenge.utils.NetworkErrorsHelper

sealed class BaseResponse {
    class Success(val data: Any) : BaseResponse()
    class Error(val errorKind: NetworkErrorsHelper.ErrorKind, val message: String? = "") : BaseResponse()
    class Loading(val isLoading: Boolean) : BaseResponse()
}