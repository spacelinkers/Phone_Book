package com.example.phone_book.ui.contactList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phone_book.R
import com.example.phone_book.data.model.Contact
import com.example.phone_book.ui.details.DetailsFragment
import com.example.phone_book.util.ContactAdapter
import com.example.phone_book.util.DataProvider
import kotlinx.android.synthetic.main.contact_fragment.*

class ContactFragment : Fragment(), ContactAdapter.OnItemCickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.contact_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactList = DataProvider.contactList
        contact_list_recycler_view.adapter = ContactAdapter(contactList, this)
    }

    override fun onItemClick(contact: Contact, itemview: View) {
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.fragment_container, DetailsFragment(), DetailsFragment().javaClass.simpleName)
            .commit()
    }
}