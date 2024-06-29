package components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.togetherWith
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FitScreen
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.compose.currentBackStackEntryAsState
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.app_name
import midilink.composeapp.generated.resources.version
import org.jetbrains.compose.resources.stringResource
import platform.LocalWindowControls
import platform.WindowControls
import theme.AppTheme
import theme.appearSmall
import theme.border
import theme.disappearSmall

val topbarHeight = 48.dp

@Composable
fun Topbar(modifier: Modifier = Modifier) {
    val windowControls = LocalWindowControls.current
    val navigator = LocalNavController.current
    val backEntry by navigator.currentBackStackEntryAsState()

    Box(modifier = Modifier.height(topbarHeight)) {
        Row(modifier = modifier.fillMaxHeight()) {
            AnimatedContent(
                backEntry,
                contentAlignment = Alignment.Center,
                transitionSpec = { appearSmall togetherWith disappearSmall },
                modifier = Modifier.fillMaxHeight()
            ) {
                when (it?.destination?.route) {
                    null, "home" -> {}

                    else -> IconButton({ navigator.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, null)
                    }
                }

            }
            windowControls.windowDragArea(Modifier.weight(1f).fillMaxHeight()) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp).fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(stringResource(Res.string.app_name), lineHeight = 1.em, fontWeight = FontWeight.Bold)
                    Text(
                        stringResource(Res.string.version),
                        fontSize = 0.6.em,
                        lineHeight = 0.6.em,
                        color = LocalContentColor.current.copy(alpha = 0.6f)
                    )
                }
            }

            Spacer(Modifier.width(8.dp))
            WindowControls(windowControls)
        }
        Spacer(
            Modifier.fillMaxWidth().height(1.dp).align(Alignment.BottomStart)
                .background(MaterialTheme.colorScheme.border)
        )
    }
}

@Composable
fun WindowControls(controls: WindowControls) {
    Row(modifier = Modifier.fillMaxHeight()) {
        WindowControlButton(Icons.Default.Minimize, controls::minimize)
        WindowControlButton(Icons.Default.FitScreen, controls::maximize)
        WindowControlButton(Icons.Default.Close, controls::close, color = Color.Red)
    }
}

@Composable
fun WindowControlButton(icon: ImageVector, onClick: () -> Unit, color: Color? = null) {
    val contentColor = LocalContentColor.current

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val currentColor by animateColorAsState(if (isHovered) color ?: contentColor else contentColor)

    CompositionLocalProvider(LocalContentColor provides currentColor) {
        Box(
            modifier = Modifier.fillMaxHeight().hoverable(interactionSource)
                .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
        ) {
            IconButton(onClick, interactionSource = interactionSource) {
                Icon(icon, null)
            }
        }
    }
}

@Preview
@Composable
private fun TopbarPreview() {
    AppTheme {
        Topbar()
    }
}
