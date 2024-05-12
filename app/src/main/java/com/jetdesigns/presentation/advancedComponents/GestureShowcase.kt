package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun GesturesShowcase() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GestureOptions()
        }
    }
}


@Composable
fun GestureOptions() {
    var showDragExample by remember { mutableStateOf(false) }
    var showPinchExample by remember { mutableStateOf(false) }

    if (showDragExample) {
        DragGestureExample { showDragExample = false }
    } else if (showPinchExample) {
        PinchGestureExample { showPinchExample = false }
    } else {
        Button(onClick = { showDragExample = true }) {
            Text("Show Drag Gesture Example")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { showPinchExample = true }) {
            Text("Show Pinch Gesture Example")
        }
    }
}

// Drag Gesture Example from previous explanation
@Composable
fun DragGestureExample(onBack: () -> Unit) {
    var offset by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    offset += dragAmount
                    change.consume()
                }
            }
            .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
    ) {
        Text("Drag me", color = Color.White)
    }

    Button(onClick = onBack) {
        Text("Back")
    }
}

// Pinch Gesture Example from previous explanation
@Composable
fun PinchGestureExample(onBack: () -> Unit) {
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = Modifier
            .background(Color.Green)
            .size(200.dp)
            .graphicsLayer(
                scaleX = maxOf(0.1f, minOf(3f, scale)),
                scaleY = maxOf(0.1f, minOf(3f, scale)),
                rotationZ = rotation,
                translationX = offset.x,
                translationY = offset.y
            )
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, rotationChange ->
                    scale *= zoom
                    rotation += rotationChange
                    offset += pan
                }
            }
    ) {
        Text("Pinch & Rotate", color = Color.White)
    }

    Button(onClick = onBack) {
        Text("Back")
    }
}