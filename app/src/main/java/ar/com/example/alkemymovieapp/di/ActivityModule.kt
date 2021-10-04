package ar.com.example.alkemymovieapp.di

import ar.com.example.alkemymovieapp.repository.remote.MovieRepository
import ar.com.example.alkemymovieapp.repository.remote.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {
    //Bindear interfaces

    @Binds
    abstract fun bindMovieRepositoryImpl(repoImpl : MovieRepositoryImpl) : MovieRepository

}