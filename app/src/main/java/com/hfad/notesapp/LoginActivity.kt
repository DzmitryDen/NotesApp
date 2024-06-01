package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<TextView>(R.id.login_email)
        val passwordField = findViewById<TextView>(R.id.login_password)

        emailField.doAfterTextChanged { text ->
            if (text.isNullOrEmpty() || text.trim().isEmpty()) {
                Toast.makeText(this, "field is required", Toast.LENGTH_SHORT).show()
            }
        }

        passwordField.doAfterTextChanged { text ->
            if (text.isNullOrEmpty() || text.trim().isEmpty()) {
                Toast.makeText(this, "field is required", Toast.LENGTH_SHORT).show()
            }
        }

        val clickQueryText = findViewById<TextView>(R.id.login_query)
        clickQueryText.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}