package com.example.phone_book.ui.addContact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.phone_book.ContactApp
import com.example.phone_book.data.model.Contact

class AddContactViewModel(application: Application) : AndroidViewModel(application) {
    private val contactRepository = getApplication<ContactApp>().getRepository()

    fun addContact(contact: Contact){
        contactRepository.insertContact(contact)
    }
}