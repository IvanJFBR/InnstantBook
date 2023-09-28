package com.example.innstantbook.extensions

import com.example.innstantbook.networking.model.NetworkingError
import com.example.innstantbook.shared.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

fun <T> executeCompleteFlowEvent(
    getData: suspend (() -> T),
    getDataCallback: (suspend (T) -> Unit?)? = null
): Flow<Event<T>> = flow {
    emit(Event.loading<Nothing>())
    val data = getData()
    getDataCallback?.invoke(data)
    emit(Event.Data(data))
    emit(Event.Idle)
}.catch { cause ->

    when (cause) {
        is NetworkingError -> {
            val errorException = Throwable(cause.errorDescription, cause.originalError)
            emit(Event.Error(errorException))
        }
        else -> {
            emit(Event.Error(cause))
        }
    }
    emit(Event.Idle)
}