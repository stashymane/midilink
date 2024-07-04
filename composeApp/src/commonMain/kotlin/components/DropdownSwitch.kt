package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> DropdownSwitch(
    items: Collection<T>,
    current: T?,
    onSelect: (T?) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        TextButton({ expanded = !expanded }) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                current?.let { content(it) } ?: Text("Not selected")
                Icon(Icons.Default.ArrowDropDown, null)
            }
        }
        DropdownMenu(expanded, { expanded = false }) {
            items.forEach {
                DropdownMenuItem({ content(it) }, {
                    onSelect(it)
                    expanded = false
                })
            }
        }
    }
}