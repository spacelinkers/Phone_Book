package com.example.phone_book.util

import com.example.phone_book.data.model.Contact

class DataProvider {
    companion object{
        val contactList = initContactList()

        private fun initContactList(): MutableList<Contact>{
            val contacts = mutableListOf<Contact>()

            contacts.add(
                Contact("Hasan1", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("Hasan", "Molla", "111"
                ))
            contacts.add(
                Contact("HasanF", "Molla", "111"
                ))

            return contacts
        }

    }
}