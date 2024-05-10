package com.jetdesigns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jetdesigns.navigation.AppNav
import com.jetdesigns.presentation.SelectionBasicListScreen
import com.jetdesigns.ui.theme.JetDesignsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetDesignsTheme {
                AppNav()
            }
        }
    }
}


