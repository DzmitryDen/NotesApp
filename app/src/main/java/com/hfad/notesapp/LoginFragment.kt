package com.hfad.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.hfad.notesapp.databinding.FragmentLoginBinding
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast

class LoginFragment : Fragment(){

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailField = binding?.loginEmail
        val passwordField = binding?.loginPassword


        emailField?.doAfterTextChanged { text ->
            validatorToast(context, checkEmpty(text), getString(R.string.error_not_empty))
        }

        passwordField?.doAfterTextChanged { text ->
            validatorToast(context, checkEmpty(text), getString(R.string.error_not_empty))
        }

        val clickQueryText = binding?.loginQuery
        clickQueryText?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .addToBackStack(null)
                .commit()
        }

        val buttonLogin = binding?.loginButton
        buttonLogin?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}