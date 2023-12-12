package com.hilal.museumapp.features.artwork

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hilal.museumapp.domain.models.Artwork
import com.hilal.museumapp.usecases.GetArtwork
import com.hilal.museumapp.utils.Error
import com.hilal.museumapp.utils.Loaded
import com.hilal.museumapp.utils.Loading
import com.hilal.museumapp.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtworkViewModel
@Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getArtwork: GetArtwork
) : ViewModel() {
    private val mutableUiStateStateFlow = MutableStateFlow<UiState<Artwork>>(Loading)
    val uiStateStateFlow: StateFlow<UiState<Artwork>> = mutableUiStateStateFlow

    private var identifier: String

    init {
        val args = ArtworkFragmentArgs.fromSavedStateHandle(savedStateHandle)
        identifier = args.identifier
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                mutableUiStateStateFlow.value = Loading
                mutableUiStateStateFlow.value = Loaded(getArtwork(identifier))
            } catch (e: Exception) {
                mutableUiStateStateFlow.value = Error(e)
            }
        }
    }
}