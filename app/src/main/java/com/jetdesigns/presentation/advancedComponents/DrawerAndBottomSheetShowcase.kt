package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jetdesigns.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetShowcase() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()


    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Image(
                painter = painterResource(id = R.drawable.ice),
                contentDescription = null
            )
        },
        sheetPeekHeight = 0.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Text(text = "Open sheet")
            }
        }
    }

//                    if(isSheetOpen) {
//                        ModalBottomSheet(
//                            sheetState = sheetState,
//                            onDismissRequest = {
//                                isSheetOpen = false
//                            },
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.kermit),
//                                contentDescription = null
//                            )
//                        }
//                    }
}
