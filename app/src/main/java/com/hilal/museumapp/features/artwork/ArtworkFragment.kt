package com.hilal.museumapp.features.artwork

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.fragment.app.viewModels
import com.hilal.museumapp.features.BaseComposableFragment
import com.hilal.museumapp.utils.Loaded
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworkFragment : BaseComposableFragment() {

    private val viewModel: ArtworkViewModel by viewModels()

    @Composable
    override fun ComposeContent() {
        val uiState by viewModel.uiStateStateFlow.collectAsState()

        when (uiState) {
            is Loaded -> ArtworkScreen(item = (uiState as Loaded).value)
            else -> {
                // TODO: handle other states
            }
        }
    }
}