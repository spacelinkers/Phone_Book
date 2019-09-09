package com.example.phone_book.ui.editContact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.phone_book.ContactApp
import com.example.phone_book.data.model.Contact

class EditViewModel(application: Application) : AndroidViewModel(application) {
    private val contactRepository = getApplication<ContactApp>().getRepository()

    fun editContact(contact: Contact){
        contactRepository.updateContact(contact)
    }
}