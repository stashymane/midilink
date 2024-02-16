package dev.stashy.midilink.ui.components.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.stashy.midilink.ui.theme.border

@Composable
fun RowScope.LayoutDivider(color: Color = MaterialTheme.colorScheme.border, width: Dp = 1.dp) {
    LayoutDivider(color, Modifier.width(width).fillMaxHeight())
}

@Composable
fun ColumnScope.LayoutDivider(color: Color = MaterialTheme.colorScheme.border, height: Dp = 1.dp) {
    LayoutDivider(color, Modifier.height(height).fillMaxWidth())
}

@Composable
private fun LayoutDivider(color: Color, modifier: Modifier = Modifier) {
    Spacer(modifier.background(color))
}
