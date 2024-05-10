package com.jetdesigns.presentation.basicComponents

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SwitchAndSliderShowcase() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var switchState by remember { mutableStateOf(false) }
            var customSwitchState by remember { mutableStateOf(false) }
            var disabledSwitchState by remember { mutableStateOf(true) } // Disabled state

            // Standard Switch
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = switchState,
                    onCheckedChange = { switchState = it }
                )
                Text(
                    text = if (switchState) "Switch is ON" else "Switch is OFF",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Switch with Custom Colors
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = customSwitchState,
                    onCheckedChange = { customSwitchState = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        uncheckedThumbColor = Color.Red,
                        checkedTrackColor = Color.Green.copy(alpha = 0.5f),
                        uncheckedTrackColor = Color.Red.copy(alpha = 0.5f)
                    )
                )
                Text(
                    text = if (customSwitchState) "Custom ON" else "Custom OFF",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Disabled Switch
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = disabledSwitchState,
                    onCheckedChange = null,
                    enabled = false,  // Use the enabled property to disable the switch
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Gray,
                        uncheckedThumbColor = Color.DarkGray,
                        checkedTrackColor = Color.Gray.copy(alpha = 0.5f),
                        uncheckedTrackColor = Color.DarkGray.copy(alpha = 0.5f)
                    )
                )
                Text(
                    text = "Disabled Switch",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            //SLIDER
Spacer(modifier = Modifier.height(40.dp))

            var sliderValue by remember { mutableStateOf(0f) }
            var stepSliderValue by remember { mutableStateOf(0f) }

            // Standard Slider
            Text("Standard Slider: ${sliderValue.toInt()}", style = MaterialTheme.typography.bodyLarge)
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // This is called when the user stops dragging the Slider.
                    println("Slider value was selected: $sliderValue")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Slider with Steps
            Text("Stepped Slider: ${stepSliderValue.toInt()}", style = MaterialTheme.typography.bodyLarge)
            Slider(
                value = stepSliderValue,
                onValueChange = { stepSliderValue = it },
                valueRange = 0f..100f,
                steps = 4,  // This creates 5 discrete values (0, 25, 50, 75, 100)
                onValueChangeFinished = {
                    // Feedback after user selection
                    println("Stepped Slider value was selected: $stepSliderValue")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Slider with Custom Colors
            Text("Slider with Custom Colors: ${sliderValue.toInt()}", style = MaterialTheme.typography.bodyLarge)
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Magenta,
                    activeTrackColor = Color.Magenta.copy(alpha = 0.5f),
                    inactiveTrackColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Disabled Slider
            Text("Disabled Slider", style = MaterialTheme.typography.bodyLarge)
            Slider(
                value = 50f, // Fixed at 50 for a disabled state
                onValueChange = {},
                enabled = false,
                valueRange = 0f..100f
            )
        }
    }
}
