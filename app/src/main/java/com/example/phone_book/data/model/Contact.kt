package com.example.phone_book.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    var firstName: String = "",
    var lastName: String = "",
    var phone: String = "",
    var favouriteFlag: Int = 0,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)