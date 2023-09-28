package com.example.innstantbook.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.innstantbook.databinding.ActivityHomeBinding
import com.example.innstantbook.di.InnstantBookModules
import com.example.innstantbook.presentation.extensions.observe
import com.example.innstantbook.presentation.extensions.viewBinding
import com.example.innstantbook.presentation.models.Menu
import com.example.innstantbook.presentation.models.MenuItem
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel {
        parametersOf()
    }

    private val binding by viewBinding(
        ActivityHomeBinding::inflate
    )

    private val layoutContainer: HomeLayoutContainer by lazy {
        HomeLayoutContainer(binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObservers()

        layoutContainer.init()
        viewModel.loadData()
    }

    private fun setupObservers() {

    }
}