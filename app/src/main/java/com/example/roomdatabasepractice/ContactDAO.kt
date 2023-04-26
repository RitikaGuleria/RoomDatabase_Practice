package com.example.roomdatabasepractice

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO
{
    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("Select * from contact")
    fun getAllContact() : LiveData<List<Contact>>
}