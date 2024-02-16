package dev.stashy.midilink.ui.components

import androidx.compose.animation.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.WindowScope
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import dev.stashy.midilink.ui.theme.AppTheme
import dev.stashy.midilink.ui.theme.surfaceAlt
import dev.stashy.midilink.ui.util.toggleMaximized
import dev.stashy.midilink.ui.util.toggleMinimized

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WindowScope.Topbar(
    isBackVisible: Boolean,
    windowState: WindowState,
    onBack: () -> Unit = {},
    onClose: () -> Unit = {}
) {
    val height = 48.dp

    Row(modifier = Modifier.height(height).background(MaterialTheme.colorScheme.surfaceAlt)) {
        Box(Modifier.weight(1f).fillMaxHeight()) {
            WindowDraggableArea(
                modifier = Modifier.matchParentSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxHeight().padding(start = 16.dp)
                ) {
                    Box(Modifier.width(height).height(height), contentAlignment = Alignment.Center) {
                        AnimatedContent(isBackVisible, modifier = Modifier.matchParentSize(), transitionSpec = {
                            fadeIn() + scaleIn(initialScale = 0.8f) togetherWith fadeOut() + scaleOut(targetScale = 0.8f)
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
                    Text("midilink")
                    Text("alpha", fontSize = 0.75.em)
                }
            }
        }

        val buttonModifier = Modifier.fillMaxHeight()
        val buttonShape = RectangleShape
        val iconModifier = Modifier.size(20.dp)

        TextButton({ windowState.toggleMinimized() }, modifier = buttonModifier, shape = buttonShape) {
            Icon(imageVector = Icons.Default.Minimize, contentDescription = "Minimize", modifier = iconModifier)
        }
        TextButton({ windowState.toggleMaximized() }, modifier = buttonModifier, shape = buttonShape) {
            Icon(imageVector = Icons.Default.CropSquare, contentDescription = "Maximize", modifier = iconModifier)
        }
        TextButton(onClose, modifier = buttonModifier, shape = buttonShape) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close", modifier = iconModifier)
        }
    }
}

@Preview
@Composable
private fun WindowScope.TopbarPreview() {
    AppTheme {
        Topbar(false, windowState = rememberWindowState())
    }
}
