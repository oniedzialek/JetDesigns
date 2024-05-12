package com.jetdesigns.presentation.designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jetdesigns.R

@Composable
fun UserProfileDesign() {
    var showDetails by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileInformation()
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { showDetails = !showDetails }) {
            Text(if (showDetails) "Hide Details" else "Show Details")
        }

        if (showDetails) {
            ExpandableProfileDetails()
        }
    }
}

@Composable
fun ProfileHeader() {
    val image: Painter = painterResource(R.drawable.profile_screen) // Change with actual resource
    Card(
        modifier = Modifier
            .size(130.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Image(painter = image, contentDescription = "Profile Picture", modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun ProfileInformation() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("John Doe", style = MaterialTheme.typography.headlineMedium)
        Text("john.doe@example.com", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ExpandableProfileDetails() {
    Column {
        Text("Additional Details", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Account created: January 1, 2020", style = MaterialTheme.typography.bodyMedium)
        Text("Membership: Gold", style = MaterialTheme.typography.bodyMedium)
        // More details can be added here
    }
}
