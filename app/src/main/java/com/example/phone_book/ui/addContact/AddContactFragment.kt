package com.example.phone_book.ui.addContact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.phone_book.R
import com.example.phone_book.data.model.Contact
import kotlinx.android.synthetic.main.add_fragment.*

class AddContactFragment : Fragment() {

    private lateinit var addContactViewModel: AddContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addContactViewModel = ViewModelProviders.of(this).get(AddContactViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_save_button.setOnClickListener {
            saveContact()
        }
    }

    private fun saveContact(){
        val contact = Contact(
            first_name_edit_text.editableText.toString(),
            last_name_edit_text.editableText.toString(),
            contact_edit_text.editableText.toString()
        )
        val id = addContactViewModel.addContact(contact)

        Log.d("AAA", ""+ id.toString())


        Navigation.findNavController(view!!).navigateUp()
    }


}