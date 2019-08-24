package com.example.phone_book.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.phone_book.data.model.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM Contact ORDER BY id DESC")
    fun getAll(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Query("DELETE FROM Contact")
    fun deleteAll()

    @Query("SELECT * FROM Contact WHERE id = :id")
    fun find(id: Int): LiveData<Contact>

    @Query("SELECT * FROM Contact WHERE firstName LIKE '%' || :name || '%'")
    fun findBy(name: String): LiveData<List<Contact>>
}