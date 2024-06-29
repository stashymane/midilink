package components

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController

val LocalNavController: ProvidableCompositionLocal<NavController> =
    compositionLocalOf { NavController() }

val LocalSnackbarState: ProvidableCompositionLocal<SnackbarHostState> =
    compositionLocalOf { SnackbarHostState() }