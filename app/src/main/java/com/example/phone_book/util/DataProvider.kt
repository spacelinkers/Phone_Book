package com.example.phone_book.util

import com.example.phone_book.data.model.Contact

class DataProvider {
    companion object{
        var contactList = initContactList()

        private fun initContactList(): MutableList<Contact>{
            var contacts = mutableListOf<Contact>()
            return contacts
        }

    }
}