package com.example.contact.presentaton.events

import com.example.contact.data.Contact

sealed interface ContactEvent {
    object SaveContact : ContactEvent
    data class SetFirstName(val firstName: String) : ContactEvent
    data class SetLastName(val lastName: String) : ContactEvent
    data class SetPhoneName(val phoneNumber: String) : ContactEvent
    object ShowDialog : ContactEvent
    object HideDialog : ContactEvent
    data class SortContact(val sortType: SortType) : ContactEvent
    data class DeleteContact(val  contact: Contact):ContactEvent
}