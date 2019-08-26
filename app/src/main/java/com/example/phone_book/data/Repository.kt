package com.example.phone_book.data.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.phone_book.data.db.ContactDao
import com.example.phone_book.data.db.ContactDatabase

class Repository(application: Application) {

    private val contactDao: ContactDao

    init {
        val contactDatabase = ContactDatabase.getInstance(application)
        contactDao = contactDatabase.contactDao()
    }

    fun getAllContact(): LiveData<List<Contact>>{
        return contactDao.getAll()
    }

    fun insertContact(contact: Contact){
        contactDao.insert(contact)
    }

    fun findContact(id: Int): LiveData<Contact>{
        return contactDao.find(id)
    }

    fun findContact(name: String): LiveData<List<Contact>>{
        return contactDao.findBy(name)
    }
}