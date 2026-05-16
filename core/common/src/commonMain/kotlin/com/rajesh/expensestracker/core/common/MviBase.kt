package com.rajesh.expensestracker.core.common

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

interface UiState
interface UiIntent
interface UiEffect

abstract class BaseViewModel<S : UiState, I : UiIntent, E : UiEffect> : ViewModel() {

    private val initialState: S by lazy { createInitialState() }
    abstract fun createInitialState(): S

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<E>()
    val effect: SharedFlow<E> = _effect.asSharedFlow()

    fun sendIntent(intent: I) {
        handleIntent(intent)
    }

    protected abstract fun handleIntent(intent: I)

    protected fun setState(reduce: S.() -> S) {
        val newState = _uiState.value.reduce()
        _uiState.value = newState
    }

    protected fun setEffect(builder: () -> E) {
        val effectValue = builder()
        viewModelScope.launch { _effect.emit(effectValue) }
    }
}
