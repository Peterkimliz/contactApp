package com.example.contact.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDto {
    @Upsert
    suspend fun upsertContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)
    @Query("SELECT * FROM contact")
    fun getAllContacts(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY firstName")
    fun getContactByFirstName(): Flow<List<Contact>>
    @Query("SELECT * FROM contact ORDER BY lastName")
    fun getContactByLastName(): Flow<List<Contact>>

}