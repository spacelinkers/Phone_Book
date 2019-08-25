package com.example.phone_book

import android.app.Application
import com.example.phone_book.data.model.Repository

class ContactApp : Application() {
    fun getRepository() = Repository(this)
}