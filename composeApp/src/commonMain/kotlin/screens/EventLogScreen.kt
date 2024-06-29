package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.tab_event_log
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.PreviewContainer

@Composable
fun EventLogScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text(stringResource(Res.string.tab_event_log), style = MaterialTheme.typography.headlineLarge)
    }
}

@Preview
@Composable
private fun EventLogScreenPreview() {
    PreviewContainer {
        EventLogScreen()
    }
}
