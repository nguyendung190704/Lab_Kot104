package com.example.lab_kot104.Lab7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_kot104.lab6.Movie

class MainViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>> = _movies

    init {
        _movies.value = Movie.getSampleMovies()
    }
}