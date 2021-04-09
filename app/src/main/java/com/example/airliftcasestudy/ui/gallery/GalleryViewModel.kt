package com.example.airliftcasestudy.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.airliftcasestudy.data.model.response.BaseDataModel
import com.example.airliftcasestudy.data.repository.MainRepository
import com.example.airliftcasestudy.data.remote.Resource
import javax.inject.Inject


class GalleryViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    /**
     * Api call for get images.
     */
    fun getData(response: MutableLiveData<Resource<BaseDataModel>>) {

        mainRepository.getData(response)
    }

}