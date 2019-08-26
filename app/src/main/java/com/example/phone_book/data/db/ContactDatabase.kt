package com.example.phone_book.data.db

import android.app.Application
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.phone_book.data.model.Contact
import com.example.phone_book.util.DataProvider

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object{
        private val lock = Any()
        private const val DB_Name = "Contact.db"
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(application: Application): ContactDatabase{
            synchronized(ContactDatabase.lock){
                if(ContactDatabase.INSTANCE == null){
                    ContactDatabase.INSTANCE =
                        Room.databaseBuilder(application, ContactDatabase::class.java, ContactDatabase.DB_Name)
                            .allowMainThreadQueries()
                            .addCallback(object : RoomDatabase.Callback(){
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    ContactDatabase.INSTANCE?.let{
                                        ContactDatabase.prePopulate(it, DataProvider.contactList)
                                    }
                                }
                            })
                            .build()
                }
                return ContactDatabase.INSTANCE!!
            }
        }

        fun prePopulate(database: ContactDatabase, contactList: List<Contact>){
            for(contact in contactList){
                AsyncTask.execute{ database.contactDao().insert(contact) }
            }
        }
    }
}