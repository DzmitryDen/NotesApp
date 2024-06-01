package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
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
            val lengthString = text.toString().length
            if (lengthString < 3 || lengthString > 255) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        lastNameField.doAfterTextChanged { text ->
            val lengthString = text.toString().length
            if (lengthString < 3 || lengthString > 255) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        emailField.doAfterTextChanged { text ->
            val str = text.toString()
            if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        passwordField.doAfterTextChanged { text ->
            val str = text.toString()
            val lengthString = str.length
            val patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$")
            val matcher = patternPassword.matcher(str)

            if ((lengthString < 6 || lengthString > 50) || !matcher.matches()) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        val clickQueryText = findViewById<TextView>(R.id.signup_query)
        clickQueryText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}