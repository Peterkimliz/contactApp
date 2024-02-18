package com.example.contact.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    val firstName: String,
    val lastName: String,
    val number: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)