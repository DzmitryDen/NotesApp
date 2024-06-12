package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.hfad.notesapp.validation.checkEmail
import com.hfad.notesapp.validation.checkSignName
import com.hfad.notesapp.validation.checkSignPassword
import com.hfad.notesapp.validation.validatorToast
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val firstNameField = findViewById<TextView>(R.id.signup_first_name)
        val lastNameField = findViewById<TextView>(R.id.signup_last_name)
        val emailField = findViewById<TextView>(R.id.signup_email)
        val passwordField = findViewById<TextView>(R.id.signup_password)


        firstNameField.doAfterTextChanged { text ->
            validatorToast(this, checkSignName(text), getString(R.string.error_common))
            }

        lastNameField.doAfterTextChanged { text ->
            validatorToast(this, checkSignName(text), getString(R.string.error_common))
        }

        emailField.doAfterTextChanged { text ->
            validatorToast(this, checkEmail(text), getString(R.string.error_common))
        }

        passwordField.doAfterTextChanged { text ->
            validatorToast(this, checkSignPassword(text), getString(R.string.error_common))
        }

        val clickQueryText = findViewById<TextView>(R.id.signup_query)
        clickQueryText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}