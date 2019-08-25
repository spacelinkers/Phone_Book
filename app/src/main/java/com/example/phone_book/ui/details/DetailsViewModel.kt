package com.example.phone_book.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.phone_book.data.model.Contact
import com.example.phone_book.data.model.Repository

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val contactId = MutableLiveData<Int>()
    private val contactRepository = Repository(getApplication())

    fun getContactDetails(id: Int): LiveData<Contact>{
        contactId.value = id
        val contactDetails = Transformations.switchMap<Int, Contact>(contactId){id->
            contactRepository.findContact(id)
        }
        return contactDetails
    }
}