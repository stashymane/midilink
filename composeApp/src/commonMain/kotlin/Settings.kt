import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.settings_theme_dark
import midilink.composeapp.generated.resources.settings_theme_light
import midilink.composeapp.generated.resources.settings_theme_system
import org.jetbrains.compose.resources.StringResource
import java.nio.file.Path

@Serializable
data class Settings(
    val theme: Theme = Theme.SYSTEM,
    val color: ULong = Color.Magenta.value,
    val configLocation: Path = Path.of("")
) {
    @Serializable
    enum class Theme(val resource: StringResource) {
        SYSTEM(Res.string.settings_theme_system),
        LIGHT(Res.string.settings_theme_light),
        DARK(Res.string.settings_theme_dark)
    }
}

val LocalAppSettings = compositionLocalOf { Settings() }
