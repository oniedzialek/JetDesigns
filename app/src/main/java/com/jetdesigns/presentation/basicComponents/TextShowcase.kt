package com.jetdesigns.presentation.basicComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextSchowcase() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(25.dp).align(Alignment.Center)) {

            Text(
                text = "Simple Text",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Bold Text",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Italic Text",
                style = MaterialTheme.typography.bodyLarge.copy(fontStyle = FontStyle.Italic)
            )
            Text(
                text = "Underlined Text",
                style = MaterialTheme.typography.bodyLarge.copy(textDecoration = TextDecoration.Underline)
            )
            Text(
                text = "Strikethrough Text",
                style = MaterialTheme.typography.bodyLarge.copy(textDecoration = TextDecoration.LineThrough)
            )
            Text(
                text = "Colored Text",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Text with Larger Font Size",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp)
            )
            Text(
                text = "Text with Letter Spacing",
                style = MaterialTheme.typography.bodyLarge.copy(letterSpacing = 2.sp)
            )
            Text(
                text = "Center Aligned Text",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}