package com.app.movielistapp.di

import com.app.movielistapp.data.repository.MoviesRepository
import com.app.movielistapp.data.sharepref.SharedPreferences
import com.app.movielistapp.shared.usecase.MoviesUseCase
import com.app.movielistapp.view.MovieDetailViewModel
import com.app.movielistapp.view.MoviesHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val singleton = module {
    single { SharedPreferences(get()) }
}

val dataSourceModule = module {
    single { MoviesRepository(get()) }
}

val useCaseModule = module {
    single { MoviesUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MoviesHomeViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}

val appComponent: List<Module> = listOf(
    singleton,
    dataSourceModule,
    useCaseModule,
    viewModelModule
)