package dev.chungjungsoo.gptmobile.presentation.ui.setting

import dev.chungjungsoo.gptmobile.data.dto.Platform
import dev.chungjungsoo.gptmobile.data.model.ApiType
import dev.chungjungsoo.gptmobile.data.repository.SettingRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}

@ExperimentalCoroutinesApi
class SettingViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SettingViewModel
    private val settingRepository: SettingRepository = mockk(relaxed = true)

    private val initialPlatforms = listOf(
        Platform(name = ApiType.OPENAI, enabled = true, apiUrl = "test_url")
    )

    @Before
    fun setUp() {
        coEvery { settingRepository.fetchPlatforms() } returns initialPlatforms
        viewModel = SettingViewModel(settingRepository)
    }

    @Test
    fun `updateURL should call updatePlatforms on repository`() = runTest {
        // Given
        val newUrl = "https://api.openai.com/v1"

        // When
        viewModel.updateURL(ApiType.OPENAI, newUrl)

        // Then
        coVerify { settingRepository.updatePlatforms(any()) }
    }

    @Test
    fun `updateToken should call updatePlatforms on repository`() = runTest {
        // Given
        val newToken = "new_token"

        // When
        viewModel.updateToken(ApiType.OPENAI, newToken)

        // Then
        coVerify { settingRepository.updatePlatforms(any()) }
    }
}
