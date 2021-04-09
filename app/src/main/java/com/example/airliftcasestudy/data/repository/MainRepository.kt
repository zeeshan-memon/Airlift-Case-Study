package com.example.airliftcasestudy.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.airliftcasestudy.data.model.response.BaseDataModel
import com.example.airliftcasestudy.data.remote.ApiService
import com.example.airliftcasestudy.data.remote.NetworkBoundResource
import com.example.airliftcasestudy.data.remote.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    fun getData(response: MutableLiveData<Resource<BaseDataModel>>): MutableLiveData<Resource<BaseDataModel>> {

        return NetworkBoundResource.loadData(
            apiService.getData(),
            BaseDataModel::class.java,
            response
        )
    }


}