package com.example.innstantbook.di

import com.example.innstantbook.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object InnstantBookModules : FeatureModules() {
    override val modules: List<Module>
        get() = listOf(viewModelModules)

    private val viewModelModules: Module = module {
        viewModel {
            HomeViewModel()
        }
    }
}