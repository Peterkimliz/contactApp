package com.example.contact.presentaton.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contact.data.Contact
import com.example.contact.data.ContactDao
import com.example.contact.presentaton.events.ContactEvent
import com.example.contact.presentaton.events.ContactState
import com.example.contact.presentaton.events.SortType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ContactViewModel(
    private val dao: ContactDao
) : ViewModel() {
    private val _state = MutableStateFlow(ContactState())
    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _contacts = _sortType.flatMapLatest { sortType ->
        when (sortType) {
            SortType.FIRST_NAME -> dao.getContactByFirstName()
            SortType.LAST_NAME -> dao.getContactByLastName()
            SortType.PHONE_NUMBER -> dao.getContactByPhoneNumber()

        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    val state = combine(_state, _sortType, _contacts) { state, sortType, contacts ->
        state.copy(
            contacts = contacts,
            sortType = sortType
        )

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())

    fun onEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.DeleteContact -> {
                viewModelScope.launch {
                    dao.deleteContact(event.contact)
                }

            }

            ContactEvent.HideDialog -> {
                _state.update {
                    it.copy(isAddingContact = false)
                }
            }

            ContactEvent.SaveContact -> {
                val firstName = state.value.firstName
                val lastName = state.value.lastName
                val phoneNumber = state.value.phoneNumber
                if (phoneNumber.isBlank() || firstName.isBlank() || lastName.isBlank()) {
                    return
                }
                val contact = Contact(
                    firstName = firstName,
                    lastName = lastName,
                    phoneNumber = phoneNumber
                )
                viewModelScope.launch {
                    dao.upsertContact(contact)
                }
                _state.update {
                    it.copy(
                        isAddingContact = false,
                        firstName = "",
                        lastName = "",
                        phoneNumber = ""
                    )
                }
            }

            is ContactEvent.SetFirstName -> {
                _state.update {
                    it.copy(firstName = event.firstName)
                }
            }

            is ContactEvent.SetLastName -> {
                _state.update {
                    it.copy(firstName = event.lastName)
                }
            }

            is ContactEvent.SetPhoneName -> {
                _state.update {
                    it.copy(firstName = event.phoneNumber)
                }
            }

            ContactEvent.ShowDialog -> {
                _state.update {
                    it.copy(isAddingContact = true)
                }
            }

            is ContactEvent.SortContact -> {
                _sortType.value = event.sortType
            }
        }
    }


}