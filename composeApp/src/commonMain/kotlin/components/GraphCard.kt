package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import model.Graph
import theme.PreviewContainer

@Composable
fun GraphCard(graph: Graph) {
    Card {
        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(graph.name, fontWeight = FontWeight.Bold)
            Text("Test Device", fontSize = 0.7.em, lineHeight = 1.em)
        }
    }
}

@Preview
@Composable
private fun GraphCardPreview() {
    PreviewContainer {
        GraphCard(Graph("test", "Test graph", listOf(), listOf()))
    }
}