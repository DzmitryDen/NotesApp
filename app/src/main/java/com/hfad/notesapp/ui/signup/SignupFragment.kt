package com.hfad.notesapp.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hfad.notesapp.R
import com.hfad.notesapp.databinding.FragmentSignupBinding
import com.hfad.notesapp.ui.login.LoginFragment

class SignupFragment: Fragment() {

    private var binding: FragmentSignupBinding? = null
    private val viewModel: SignupViewModel by viewModels()

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

        viewModel.checkSignName(firstNameField, context)
        viewModel.checkSignName(lastNameField, context)
        viewModel.checkEmail(emailField, context)
        viewModel.checkSignPassword(passwordField, context)

        val clickQueryText = binding?.signupQuery
        clickQueryText?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}