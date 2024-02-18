package com.example.contact.presentaton.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult.ActionPerformed
import androidx.compose.material3.SnackbarResult.Dismissed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.contact.presentaton.components.AppBar
import kotlinx.coroutines.launch

@Composable
fun HomePage() {
    val mContext = LocalContext.current;
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope= rememberCoroutineScope();
    Scaffold(
        topBar = {
            AppBar("Home")
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                shape = FloatingActionButtonDefaults.largeShape,
                onClick = {
//                    Toast.makeText(mContext, "Clicked Add button", Toast.LENGTH_LONG).show()
                    scope.launch {
                       val result = snackbarHostState.showSnackbar(message = "Hello there",actionLabel = "null", duration = SnackbarDuration.Indefinite, withDismissAction = true);
                        when(result){
                            Dismissed -> TODO()
                            ActionPerformed -> TODO()
                        }
                    }

                }) {

                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")

            }
        }
        , snackbarHost = {
            snackbarHostState
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

        }

    }

}