package com.example.jsonparsingapplication.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsonparsingapplication.domain.HomeUseCase
import androidx.lifecycle.viewModelScope
import com.example.jsonparsingapplication.data.model.ErrorModel
import com.example.jsonparsingapplication.data.model.FactsDTO
import com.example.jsonparsingapplication.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch

class HomeViewModel constructor(var homeUseCase: HomeUseCase): ViewModel() {

    val factsList = MutableLiveData<FactsDTO>()

    var errorMessage = MutableLiveData<String>()

    fun fetchFactsList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                homeUseCase.invoke(viewModelScope,
                    null,
                    object : UseCaseResponse<FactsDTO> {
                        override fun onError(errorModel: ErrorModel?) {
                            errorMessage.postValue(errorModel?.message)
                        }

                        override fun onSuccess(result: FactsDTO) {
                            factsList.postValue(result)
                        }

                    }
                )
            }
        }
    }
}