package com.hfad.notesapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hfad.notesapp.R
import com.hfad.notesapp.databinding.FragmentLoginBinding
import com.hfad.notesapp.repositories.SharedPreferencesRepository
import com.hfad.notesapp.ui.home.HomeFragment
import com.hfad.notesapp.ui.notes.NotesFragment
import com.hfad.notesapp.ui.signup.SignupFragment
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(){

    @Inject
    lateinit var sharedPreferencesRepository:SharedPreferencesRepository

    private var binding: FragmentLoginBinding? = null
    private val viewModel: LoginViewModel by viewModels()

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

        viewModel.checkEmpty(emailField, context)
        viewModel.checkEmpty(passwordField, context)

        val clickQueryText = binding?.loginQuery
        clickQueryText?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .addToBackStack(null)
                .commit()
        }

        val buttonLogin = binding?.loginButton
        buttonLogin?.setOnClickListener {
            sharedPreferencesRepository.setEmail(emailField.toString())
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment()/*NotesFragment()*/)
                .addToBackStack(null)
                .commit()
        }

    }
}