package todoflutter.com.econofy.feature.onboarding.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import todoflutter.com.core.preferences.Preferences
import todoflutter.com.econofy.feature.onboarding.domain.models.usecases.OnboardingModel
import todoflutter.com.econofy.ui.extensions.isNotZero
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val preferences: Preferences,
    @ApplicationContext context: Context
) : ViewModel() {
    // Holds the state of the Home screen
    private val _state = MutableStateFlow(ServiceDetailState())

    val state: StateFlow<ServiceDetailState> get() = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SideEffect>(replay = 0)
    val sideEffect = _sideEffect.asSharedFlow()


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

        if ((currentIndex + 1) < state.value.steps.size) {
            _state.update {
                it.copy(
                    currentIndex = currentIndex + 1
                )
            }
        } else {
            preferences.isFirstOpened = false

            viewModelScope.launch {
                _sideEffect.emit(SideEffect.GoToAuthentication)
            }
        }
    }

    sealed class SideEffect {
        object GoToAuthentication : SideEffect()
    }


    data class ServiceDetailState(
        val steps: List<OnboardingModel> = OnboardingModel.data, val currentIndex: Int = 0
    )
}