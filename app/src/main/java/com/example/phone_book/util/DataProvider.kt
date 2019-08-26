package com.example.phone_book.util

import com.example.phone_book.data.model.Contact

class DataProvider {
    companion object{
        var contactList = initContactList()

        private fun initContactList(): MutableList<Contact>{
            var contacts = mutableListOf<Contact>()

            contacts.add(
                Contact("Hasan1", "Molla", "111",1
                ))
            contacts.add(
                Contact("Hasan2", "Molla", "111",2
                ))
            contacts.add(
                Contact("Hasan3", "Molla", "111",3
                ))
            contacts.add(
                Contact("Hasan4", "Molla", "111",4
                ))
            contacts.add(
                Contact("Hasan5", "Molla", "111",5
                ))
            contacts.add(
                Contact("Hasan6", "Molla", "111",6
                ))
            contacts.add(
                Contact("Hasan7", "Molla", "111",7
                ))
            contacts.add(
                Contact("Hasan8", "Molla", "111",8
                ))
            contacts.add(
                Contact("Hasan9", "Molla", "111",9
                ))
            contacts.add(
                Contact("Hasan10", "Molla", "111",10
                ))
            contacts.add(
                Contact("Hasan11", "Molla", "111",11
                ))
            contacts.add(
                Contact("Hasan12", "Molla", "111",12
                ))
            contacts.add(
                Contact("Hasan13", "Molla", "111",13
                ))
            contacts.add(
                Contact("Hasan14", "Molla", "111",14
                ))
            contacts.add(
                Contact("Hasan15", "Molla", "111",15
                ))
            contacts.add(
                Contact("Hasan16", "Molla", "111",16
                ))
            contacts.add(
                Contact("Hasan17", "Molla", "111",17
                ))
            contacts.add(
                Contact("Hasan18", "Molla", "111",18
                ))
            contacts.add(
                Contact("Hasan19", "Molla", "111",19
                ))
            contacts.add(
                Contact("Hasan20", "Molla", "111",20
                ))
            contacts.add(
                Contact("Hasan21", "Molla", "111",21
                ))
            contacts.add(
                Contact("Hasan22", "Molla", "111",22
                ))
            contacts.add(
                Contact("Hasan23", "Molla", "111",23
                ))
            contacts.add(
                Contact("HasanF", "Molla", "111",24
                ))

            return contacts
        }

    }
}