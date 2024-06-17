package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.hfad.notesapp.databinding.ActivityLoginBinding
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val emailField = binding?.loginEmail
        val passwordField = binding?.loginPassword

        emailField?.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
        }

        passwordField?.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
        }

        val clickQueryText = binding?.loginQuery
        clickQueryText?.setOnClickListener {
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