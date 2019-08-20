package com.example.phone_book.util

import com.example.phone_book.data.model.ContactModel

class DataProvider {
    companion object{
        val contactList = initContactList()

        private fun initContactList(): MutableList<ContactModel>{
            val contacts = mutableListOf<ContactModel>()

            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            contacts.add(
                ContactModel(
                    "Hasan",
                    "Molla",
                    "111"
                ))
            return contacts
        }

    }
}