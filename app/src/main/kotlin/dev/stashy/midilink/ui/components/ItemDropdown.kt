package dev.stashy.midilink.ui.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.stashy.midilink.ui.theme.AppTheme

interface ItemDropdownScope {
    var expanded: Boolean
}

@Composable
fun ItemDropdown(title: @Composable () -> Unit = {}, items: @Composable ItemDropdownScope.() -> Unit) {
    var visible by remember { mutableStateOf(false) }
    val scope = object : ItemDropdownScope {
        override var expanded: Boolean
            get() = visible
            set(value) {
                visible = value
            }
    }

    TextButton({ visible = !visible }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            title()
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Open")
        }
    }

    DropdownMenu(visible, { visible = false }) {
        items(scope)
    }
}

@Composable
fun ItemDropdownScope.Item(
    text: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    enabled: Boolean = true,
    colors: MenuItemColors = MenuDefaults.itemColors(),
    contentPadding: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    interactionSource: MutableInteractionSource = MutableInteractionSource()
) {
    DropdownMenuItem(
        text, {
            onClick()
            expanded = false
        },
        modifier,
        leadingIcon,
        trailingIcon,
        enabled,
        colors,
        contentPadding,
        interactionSource
    )
}

@Preview
@Composable
private fun ItemDropdownPreview() {
    AppTheme {
        ItemDropdown(title = { Text("Dropdown") }) {
            Item(text = { Text("Item 1") }, onClick = {})
        }
    }
}
