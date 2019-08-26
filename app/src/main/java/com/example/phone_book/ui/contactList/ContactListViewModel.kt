package com.example.phone_book.ui.contactList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.phone_book.ContactApp
import com.example.phone_book.data.model.Contact

class ContactListViewModel(application: Application): AndroidViewModel(application) {

    private val contactRepository = getApplication<ContactApp>().getRepository()
    private val contactList = MediatorLiveData<List<Contact>>()

    init {
        getAllContact()
    }

    fun getContactList(): LiveData<List<Contact>>{
        return contactList
    }

    fun getAllContact(){
        contactList.addSource(contactRepository.getAllContact()){ contacts ->
            contactList.postValue(contacts)
        }
    }

}