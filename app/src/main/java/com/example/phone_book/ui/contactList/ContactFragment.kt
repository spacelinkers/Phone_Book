package com.example.phone_book.ui.contactList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.phone_book.R
import com.example.phone_book.data.model.Contact
import com.example.phone_book.ui.details.DetailsFragment
import com.example.phone_book.util.ContactAdapter
import com.example.phone_book.util.DataProvider
import kotlinx.android.synthetic.main.contact_fragment.*

class ContactFragment : Fragment(), ContactAdapter.OnItemCickListener{

    private lateinit var contactListViewModel: ContactListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactListViewModel = ViewModelProviders.of(this).get(ContactListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.contact_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactListViewModel.getContactList().observe(this, Observer<List<Contact>> { contacts ->
            contacts?.let {
                populateContactList(contacts)
            }
        })

        // navigate to search fragment.
        search_bar.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_contact_to_searchFragment)
        }
    }

    private fun populateContactList(contactList: List<Contact>){
        contact_list_recycler_view.adapter = ContactAdapter(contactList, this)
    }

    override fun onItemClick(contact: Contact, itemview: View) {
        val infoBundle = Bundle()
        infoBundle.putInt(getString(R.string.CONTACT_ID), contact.id)
        findNavController().navigate(R.id.action_contactFragment_to_detailsFragment, infoBundle)
    }
}