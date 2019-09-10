package com.example.phone_book.ui.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.phone_book.ContactApp
import com.example.phone_book.data.model.Contact

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val contactId = MutableLiveData<Int>()
    private val contactRepository = getApplication<ContactApp>().getRepository()

    fun getContactDetails(id: Int): LiveData<Contact>{
        contactId.value = id
        val contactDetails = Transformations.switchMap<Int, Contact>(contactId){id->
            contactRepository.findContact(id)
        }
        Log.i("AAA", ""+ contactDetails.value)
        return contactDetails
    }

    fun setAddToFavourite(favouriteFlag: Int, id: Int){
        contactRepository.updateFavourite(favouriteFlag, id)
    }
}