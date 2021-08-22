package com.example.jetpack.viewModel

import android.util.Log
import android.widget.Toast
import androidx.annotation.UiThread
import androidx.lifecycle.ViewModel
import com.example.jetpack.data.Repository
import com.example.jetpack.data.network.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.*

@HiltViewModel
class mainViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    fun login(){
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.w("Network", "Caught $exception")
        }
        CoroutineScope(Dispatchers.IO).launch(handler) {
            val call = repository.getUser()
        }
    }
}