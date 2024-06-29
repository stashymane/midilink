package theme

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

val appearSmall = fadeIn() + scaleIn(initialScale = 0.8f)
val disappearSmall = fadeOut() + scaleOut(targetScale = 0.8f)

val appearLarge = fadeIn() + scaleIn(initialScale = 0.95f)
val disappearLarge = fadeOut() + scaleOut(targetScale = 0.95f)
