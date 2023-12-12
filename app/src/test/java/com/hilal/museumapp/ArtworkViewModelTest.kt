import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.hilal.museumapp.domain.models.Artwork
import com.hilal.museumapp.features.artwork.ArtworkViewModel
import com.hilal.museumapp.usecases.GetArtwork
import com.hilal.museumapp.utils.Error
import com.hilal.museumapp.utils.Loaded
import com.hilal.museumapp.utils.Loading
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArtworkViewModelTest {
    @Mock
    private lateinit var savedStateHandle: SavedStateHandle

    @Mock
    private lateinit var getArtwork: GetArtwork

    private lateinit var viewModel: ArtworkViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = ArtworkViewModel(savedStateHandle, getArtwork)
    }

    @Test
    fun `test fetching artwork successfully`() = runTest {
        // Arrange
        val identifier = "your_identifier"
        val artwork = Artwork(
            identifier = identifier,
            title = "Artwork Title",
            imageUrl = "https://example.com/image.jpg",
            description = "Artwork Description",
            subtitle = "Subtitle",
            physicalMedium = "Physical Medium"
        )

        // Mock GetArtwork's behavior
        Mockito.`when`(getArtwork(identifier)).thenReturn(artwork)

        // Act
        viewModel.uiStateStateFlow.collect {
            // Assert
            when (it) {
                is Loading -> {
                    // Loading state
                    Assert.assertTrue(true)
                }
                is Loaded -> {
                    // Loaded state
                    val loadedArtwork = it.value
                    Assert.assertEquals(artwork, loadedArtwork)
                }
                is Error -> {
                    // Error state
                    Assert.fail("Error state should not be reached")
                }
            }
        }

        // Advance the dispatcher to ensure coroutine execution
        advanceUntilIdle()
    }

    @Test
    fun `test fetching artwork with error`() = runTest {
        // Arrange
        val identifier = "your_identifier"
        val error = Exception("Artwork retrieval failed")

        // Mock GetArtwork's behavior to throw an exception
        Mockito.`when`(getArtwork(identifier)).thenThrow(error)

        // Act
        viewModel.uiStateStateFlow.collect {
            // Assert
            when (it) {
                is Loading -> {
                    // Loading state
                    Assert.assertTrue(true)
                }
                is Loaded -> {
                    // Loaded state
                    Assert.fail("Loaded state should not be reached")
                }
                is Error -> {
                    // Error state
                    val errorException = it.exception
                    Assert.assertEquals(error, errorException)
                }
            }
        }

        // Advance the dispatcher to ensure coroutine execution
        advanceUntilIdle()
    }
}
