package com.example.phone_book.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.phone_book.R
import com.example.phone_book.data.model.Contact
import kotlinx.android.synthetic.main.details_item.*

class DetailsFragment : Fragment() {
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.details_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactId = arguments!!.getInt(getString(R.string.CONTACT_ID))
        Log.d("AAA", ""+ contactId.toString())
        contactId.let {
            detailsViewModel.getContactDetails(contactId).observe(this, Observer { contactDetails ->
                populateContactDetails(contactDetails)
                dialInit(contactDetails)
            })
        }

        edit_contact_button.setOnClickListener{
            val infoBundle = Bundle()
            infoBundle.putInt(getString(R.string.CONTACT_ID), contactId)
            findNavController().navigate(R.id.action_detailsFragment_to_editFragment, infoBundle)
        }
    }

    private fun populateContactDetails(contact: Contact?){
        details_name.text = contact?.firstName + " " + contact?.lastName
        details_contact_text_view.text = contact?.phone
    }

    private fun dialInit(contact: Contact){
        dial_button.setOnClickListener{
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:${contact.phone}")
            context?.startActivity(dialIntent)
        }
    }
}