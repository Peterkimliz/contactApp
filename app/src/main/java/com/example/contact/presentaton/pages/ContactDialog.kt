package com.example.contact.presentaton.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact.presentaton.events.ContactEvent
import com.example.contact.presentaton.events.ContactState

@Composable
fun ContactDialog(
    state: ContactState, onEvent: (ContactEvent) -> Unit, modifier: Modifier = Modifier
) {

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(ContactEvent.SaveContact)
                }) {
                    Text(text = "Save")
                }

            }
        }, title = {
            Text(text = "Add Contact")
        }, text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(value = state.firstName,
                    placeholder = {
                        Text(text = "First Name")
                    },
                    onValueChange = {
                        onEvent(ContactEvent.SetFirstName(it))
                    })
                TextField(value = state.lastName,
                    placeholder = {
                        Text(text = "Last Name")
                    },
                    onValueChange = {
                        onEvent(ContactEvent.SetLastName(it))
                    })
                TextField(value = state.phoneNumber,
                    placeholder = {
                        Text(text = "Phone  Number")
                    },
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneName(it))
                    })

            }
        })
}