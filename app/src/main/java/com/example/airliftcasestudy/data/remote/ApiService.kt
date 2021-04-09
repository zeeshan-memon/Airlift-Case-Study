package com.example.airliftcasestudy.data.remote

import com.example.airliftcasestudy.data.model.response.BaseDataModel
import retrofit2.Call
import retrofit2.http.*

/**
 * We use this interface to provide url, methods and model of apis for retrofit.
 */
interface ApiService {


    //    Get Data
    @GET("?key=21067864-7887b6dd893a2ea5d1b3130c8&q=yellow+flowers&image_type=photo&pretty=true")
    fun getData():
            Call<BaseDataModel>

}