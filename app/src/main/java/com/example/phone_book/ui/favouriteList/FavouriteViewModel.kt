package com.example.phone_book.ui.favouriteList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.phone_book.ContactApp
import com.example.phone_book.data.model.Contact

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {

    private val contactRepository = getApplication<ContactApp>().getRepository()
    private val favouriteList = MediatorLiveData<List<Contact>>()

    init{
        getFavouriteContact()
    }

    fun getFavouriteList(): LiveData<List<Contact>>{
        return favouriteList
    }

    fun getFavouriteContact(){
        favouriteList.addSource(contactRepository.getAllFavouriteContact(1)){favourite ->
            favouriteList.postValue(favourite)
        }
    }
}