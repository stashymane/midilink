package dev.stashy.midilink.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.togetherWith
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.WindowScope
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import dev.stashy.midilink.ui.theme.AppTheme
import dev.stashy.midilink.ui.theme.appear
import dev.stashy.midilink.ui.theme.disappear
import dev.stashy.midilink.ui.util.toggleMaximized
import dev.stashy.midilink.ui.util.toggleMinimized
import midilink.app.BuildConfig

@Composable
fun WindowScope.Topbar(
    isBackVisible: Boolean,
    windowState: WindowState,
    onBack: () -> Unit = {},
    onClose: () -> Unit = {}
) {
    val height = 42.dp

    Row(modifier = Modifier.height(height)) {
        Box(Modifier.weight(1f).fillMaxHeight()) {
            WindowDraggableArea(modifier = Modifier.matchParentSize()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxHeight().padding(start = 8.dp)
                ) {
                    Box(
                        Modifier.width(height).height(height),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedContent(isBackVisible, modifier = Modifier.matchParentSize(), transitionSpec = {
                            appear() togetherWith disappear()
                        }) {
                            if (it) {
                                IconButton(onBack) {
                                    Icon(Icons.Default.ArrowBack, contentDescription = "Arrow back")
                                }
                            } else {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(imageVector = Icons.Default.Tune, contentDescription = "App icon")
                                }
                            }
                        }
                    }
                    Spacer(Modifier.width(4.dp))
                    Text(BuildConfig.APP_NAME)
                    Text(BuildConfig.VERSION, fontSize = 0.75.em)
                }
            }
        }

        WindowControlButton({ windowState.toggleMinimized() }, Icons.Default.Minimize)
        WindowControlButton({ windowState.toggleMaximized() }, Icons.Default.CropSquare)
        WindowControlButton(onClose, Icons.Default.Close)
    }
}

@Composable
fun WindowControlButton(onClick: () -> Unit, icon: ImageVector) {
    TextButton(
        onClick,
        Modifier.fillMaxHeight(),
        shape = RectangleShape,
        colors = ButtonDefaults.textButtonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(20.dp))
    }
}

@Preview
@Composable
private fun WindowScope.TopbarPreview() {
    AppTheme {
        Topbar(false, windowState = rememberWindowState())
    }
}
