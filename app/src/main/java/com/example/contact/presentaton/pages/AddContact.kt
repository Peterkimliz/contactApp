package com.example.contact.presentaton.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.contact.presentaton.components.AppBar

@Composable
fun AddContact() {
    val mContext = LocalContext.current
    Scaffold(
        topBar = {
            AppBar(title = "Add Note", showBackButton = true)
        }, floatingActionButton = {
            FloatingActionButton(
                shape = FloatingActionButtonDefaults.largeShape,
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = {
                    Toast.makeText(mContext, "Saving note", Toast.LENGTH_LONG).show()
                }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Save Contact")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {


        }

    }
}