package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<TextView>(R.id.login_email)
        val passwordField = findViewById<TextView>(R.id.login_password)

        emailField.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
        }

        passwordField.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
        }

        val clickQueryText = findViewById<TextView>(R.id.login_query)
        clickQueryText.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        val buttonLogin = findViewById<Button>(R.id.login_button)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }
    }
}