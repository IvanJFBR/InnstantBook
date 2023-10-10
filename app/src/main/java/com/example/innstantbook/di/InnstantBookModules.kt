package com.example.innstantbook.di

import com.example.innstantbook.domain.ApiService
import com.example.innstantbook.domain.iteractors.GetClientsIteractor
import com.example.innstantbook.domain.iteractors.GetHotelsIteractor
import com.example.innstantbook.domain.iteractors.GetRoomsIteractor
import com.example.innstantbook.networking.ApiServiceImpl
import com.example.innstantbook.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object InnstantBookModules : FeatureModules() {
    override val modules: List<Module>
        get() = listOf(
            viewModelModules,
            domainModules,
            networkingModules
        )

    private val viewModelModules: Module = module {
        viewModel {
            HomeViewModel(get(), get())
        }
    }

    private val domainModules: Module = module {
        factory { GetHotelsIteractor(get()) }
        factory { GetClientsIteractor(get()) }
        factory { GetRoomsIteractor(get()) }
    }

    private val networkingModules: Module = module {
        factory<ApiService> { ApiServiceImpl() }
    }
}