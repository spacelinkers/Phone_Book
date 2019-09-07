package com.example.phone_book.ui.editContact

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.phone_book.R
import com.example.phone_book.data.model.Contact
import com.example.phone_book.ui.details.DetailsViewModel
import kotlinx.android.synthetic.main.add_fragment.*

class EditFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleText: TextView = view.findViewById(R.id.contact_title)
        titleText.setText(getString(R.string.edit_contact))

        val contactId = arguments?.getInt(getString(R.string.CONTACT_ID))
        Log.d("BBB", ""+ contactId.toString())
        contactId?.let {
            detailsViewModel.getContactDetails(contactId).observe(this, Observer { contactDetails ->
                populateEditDetails(contactDetails)
            })
        }

        //close keyboard after touching any where in layout.
        add_fragment_layout.setOnTouchListener(View.OnTouchListener { view, ev ->
            context?.hideKeyboard(view)
            false
        })

        fab_save_button.setOnClickListener {
            //close keyboard after pressing button.
            context?.hideKeyboard(view)
        }
    }

    private fun populateEditDetails(contact: Contact?){
        first_name_edit_text.setText(contact?.firstName)
        last_name_edit_text.setText(contact?.lastName)
        contact_edit_text.setText(contact?.phone)
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
