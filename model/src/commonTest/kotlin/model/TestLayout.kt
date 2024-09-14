package model

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import model.device.Container
import model.device.Element
import kotlin.test.Test

class TestLayout {
    @Test
    fun testLayout() {
        val layout: Container =
            Container.Column(
                listOf(
                    Container.Row(
                        listOf(
                            Element.Knob(1),
                            Element.Pad(2),
                            Element.Fader(3, 2)
                        )
                    ),
                    Container.Row(
                        listOf(Element.Keyboard(11..15, 5))
                    )
                )
            )

        println(Json.encodeToString(layout))
    }
}