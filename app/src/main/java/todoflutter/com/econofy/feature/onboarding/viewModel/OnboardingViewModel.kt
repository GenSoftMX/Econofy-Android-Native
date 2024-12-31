package todoflutter.com.econofy.feature.onboarding.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import todoflutter.com.econofy.feature.onboarding.domain.models.usecases.OnboardingModel
import todoflutter.com.econofy.ui.extensions.isNotZero

class OnboardingViewModel : ViewModel() {
    // Holds the state of the Home screen
    private val _state = MutableStateFlow(ServiceDetailState())

    val state: StateFlow<ServiceDetailState> get() = _state.asStateFlow()

    fun pev() {
        val currentIndex = state.value.currentIndex

        if (currentIndex.isNotZero()) {
            _state.update {
                it.copy(
                    currentIndex = currentIndex - 1
                )
            }
        } else {
            print("can pev")
        }
    }

    fun next() {
        val currentIndex = state.value.currentIndex

        if ( (currentIndex + 1) < state.value.steps.size) {
            _state.update {
                it.copy(
                    currentIndex = currentIndex + 1
                )
            }
        } else {
            print("can next")
        }
    }

    data class ServiceDetailState(
        val steps: List<OnboardingModel> = OnboardingModel.data, val currentIndex: Int = 0
    )
}