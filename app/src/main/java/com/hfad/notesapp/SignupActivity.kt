package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.hfad.notesapp.databinding.ActivityNotesBinding
import com.hfad.notesapp.databinding.ActivitySignupBinding
import com.hfad.notesapp.validation.checkEmail
import com.hfad.notesapp.validation.checkSignName
import com.hfad.notesapp.validation.checkSignPassword
import com.hfad.notesapp.validation.validatorToast
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    private var binding: ActivitySignupBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val firstNameField = binding?.signupFirstName
        val lastNameField = binding?.signupLastName
        val emailField = binding?.signupEmail
        val passwordField = binding?.signupPassword


        firstNameField?.doAfterTextChanged { text ->
            validatorToast(this, checkSignName(text), getString(R.string.error_common))
            }

        lastNameField?.doAfterTextChanged { text ->
            validatorToast(this, checkSignName(text), getString(R.string.error_common))
        }

        emailField?.doAfterTextChanged { text ->
            validatorToast(this, checkEmail(text), getString(R.string.error_common))
        }

        passwordField?.doAfterTextChanged { text ->
            validatorToast(this, checkSignPassword(text), getString(R.string.error_common))
        }

        val clickQueryText = binding?.signupQuery
        clickQueryText?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}