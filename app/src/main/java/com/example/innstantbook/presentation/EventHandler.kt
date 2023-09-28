package com.example.innstantbook.presentation

import androidx.lifecycle.MutableLiveData
import com.example.innstantbook.shared.Event

class EventHandler<T>(
    private val event: Event<T>,
    private val loadingLiveData: MutableLiveData<Boolean>? = null
) {
    private var onIdleAction: (suspend () -> Unit) = {}
    private var onDataAction: (suspend (T) -> Unit) = {}
    private var onErrorTypeAction: ((Throwable) -> Unit) = {}
    private var onErrorAction: (suspend (String?) -> Unit) = {}
    private var onLoadingAction: (suspend (Boolean) -> Unit) = {}

    fun setOnData(onData: suspend (T) -> Unit) = apply {
        this.onDataAction = onData
    }

    fun setOnError(onError: suspend (String?) -> Unit) = apply {
        this.onErrorAction = onError
    }

    fun setOnErrorType(onErrorType: (Throwable) -> Unit) = apply {
        this.onErrorTypeAction = onErrorType
    }

    fun setLoading(onLoading: (suspend (Boolean) -> Unit)) = apply {
        this.onLoadingAction = onLoading
    }

    fun setOnIdle(onIdle: (suspend () -> Unit)) = apply {
        this.onIdleAction = onIdle
    }

    suspend fun handle() {
        when (event) {
            is Event.Data -> {
                onDataAction(event.data)
            }
            is Event.Error -> {
                onErrorTypeAction(event.error)
                onErrorAction(event.error.message)
            }
            Event.Loading -> {
                loadingLiveData?.value = true
                onLoadingAction(true)
            }
            Event.Idle -> {
                loadingLiveData?.value = false
                onLoadingAction(false)
                onIdleAction()
            }
        }
    }
}