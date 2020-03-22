package com.example.jsonparsingapplication.di

import com.example.jsonparsingapplication.data.ApiErrorHandler
import com.example.jsonparsingapplication.data.ApiService
import com.example.jsonparsingapplication.data.datasource.FactsDataSource
import com.example.jsonparsingapplication.data.datasource.FactsDataSourceImpl
import com.example.jsonparsingapplication.data.repository.FactsRepository
import com.example.jsonparsingapplication.data.repository.FactsRepositoryImpl
import com.example.jsonparsingapplication.domain.HomeUseCase
import com.example.jsonparsingapplication.ui.viewModel.HomeViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val FactsModule = module {

    viewModel { HomeViewModel(get()) }

    single { createHomeUseCase(get(), createApiErrorHandle()) }

    // single instance of PostsRepository
    single { createFactsDataSource(get()) }

    single { createFactsListRepository(get()) }
}


fun createApiErrorHandle(): ApiErrorHandler {
    return ApiErrorHandler()
}

fun createFactsDataSource(apiService: ApiService) : FactsDataSource {
    return FactsDataSourceImpl(apiService)
}
fun createFactsListRepository(networkDataSource: FactsDataSource): FactsRepository {
    return FactsRepositoryImpl(networkDataSource)
}

fun createHomeUseCase(
    postsRepository: FactsRepository,
    apiErrorHandler: ApiErrorHandler
): HomeUseCase {
    return HomeUseCase(
        postsRepository,
        apiErrorHandler
    )
}