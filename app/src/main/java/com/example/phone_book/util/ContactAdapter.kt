package com.example.phone_book.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_book.R
import com.example.phone_book.data.model.Contact
import kotlinx.android.synthetic.main.contact_list_item.view.*

class ContactAdapter(private val contactList: List<Contact>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindContact(contactList[position])
    }

    class ViewHolder(contactView: View): RecyclerView.ViewHolder(contactView){
        fun bindContact(contact: Contact) = with(itemView){
            contact_name_textView.text = contact.firstName
        }
    }

}