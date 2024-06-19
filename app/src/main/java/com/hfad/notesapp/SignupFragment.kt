package com.hfad.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.hfad.notesapp.databinding.FragmentSignupBinding
import com.hfad.notesapp.validation.checkEmail
import com.hfad.notesapp.validation.checkSignName
import com.hfad.notesapp.validation.checkSignPassword
import com.hfad.notesapp.validation.validatorToast

class SignupFragment: Fragment() {

    private var binding: FragmentSignupBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstNameField = binding?.signupFirstName
        val lastNameField = binding?.signupLastName
        val emailField = binding?.signupEmail
        val passwordField = binding?.signupPassword

        firstNameField?.doAfterTextChanged { text ->
            validatorToast(context, checkSignName(text), getString(R.string.error_common))
        }

        lastNameField?.doAfterTextChanged { text ->
            validatorToast(context, checkSignName(text), getString(R.string.error_common))
        }

        emailField?.doAfterTextChanged { text ->
            validatorToast(context, checkEmail(text), getString(R.string.error_common))
        }

        passwordField?.doAfterTextChanged { text ->
            validatorToast(context, checkSignPassword(text), getString(R.string.error_common))
        }

        val clickQueryText = binding?.signupQuery
        clickQueryText?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}