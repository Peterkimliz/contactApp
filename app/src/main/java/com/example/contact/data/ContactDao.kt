package com.example.contact.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    suspend fun deleteContact(contact: Contact)
    @Query("SELECT * FROM contact")
    fun getAllContacts(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    fun getContactByFirstName(): Flow<List<Contact>>
    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContactByLastName(): Flow<List<Contact>>
    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContactByPhoneNumber(): Flow<List<Contact>>

}