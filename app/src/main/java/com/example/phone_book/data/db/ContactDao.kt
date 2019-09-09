package com.example.phone_book.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.phone_book.data.model.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM Contact ORDER BY firstName")
    fun getAll(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Query("DELETE FROM Contact")
    fun deleteAll()

    @Query("SELECT * FROM Contact WHERE id = :id")
    fun find(id: Int): LiveData<Contact>

    @Query("SELECT * FROM Contact WHERE firstName LIKE '%' || :name || '%'")
    fun findBy(name: String): LiveData<List<Contact>>

    //@Query("UPDATE contact SET firstName = :firstName, lastName = :lastName, phone = :phone WHERE id = :id")
    //fun update(firstName: String, lastName:String, phone: String, id: Int)

    @Update
    fun update(contact: Contact)
}