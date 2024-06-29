import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable
import java.nio.file.Path

@Serializable
data class AppSettings(
    val isDark: Boolean = true,
    val color: ULong = Color.Magenta.value,
    val configLocation: Path = Path.of("")
)

val LocalAppSettings = compositionLocalOf { AppSettings() }
