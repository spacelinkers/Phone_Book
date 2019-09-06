package com.example.phone_book.ui.addContact

import android.app.Activity
import android.content.Context
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
import android.view.inputmethod.InputMethodManager
import android.view.View.OnTouchListener


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

        //close keyboard after touching any where in layout.
        add_fragment_layout.setOnTouchListener( OnTouchListener{ view, ev ->
            context?.hideKeyboard(view)
            false
        })

        fab_save_button.setOnClickListener {
            //close keyboard after pressing button.
            context?.hideKeyboard(view)
            saveContact()
        }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun saveContact(){
        val contact = Contact(
            first_name_edit_text.editableText.toString(),
            last_name_edit_text.editableText.toString(),
            contact_edit_text.editableText.toString()
        )
        if(first_name_edit_text.text.toString()=="" || last_name_edit_text.toString()==""||contact_edit_text.toString()==""){
            Navigation.findNavController(view!!).navigateUp()
            //findNavController().navigateUp()
            Log.d("AAA", "Empty")
        }
        else{
            addContactViewModel.addContact(contact)
            Log.d("AAA", "Full")
            Navigation.findNavController(view!!).navigateUp()
            //findNavController().navigateUp()
        }

    }


}