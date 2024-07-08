package com.hfad.notesapp.ui.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hfad.notesapp.R
import com.hfad.notesapp.repositories.SharedPreferencesRepository
import com.hfad.notesapp.ui.login.LoginFragment
import com.hfad.notesapp.ui.mainfragment.MainFragment
import com.hfad.notesapp.ui.notes.NotesFragment
import com.hfad.notesapp.ui.signup.SignupFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (SharedPreferencesRepository.isFirstLaunch()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()
        } else {
            if (SharedPreferencesRepository.getEmail() != null) {
                setContentView(R.layout.activity_main)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, NotesFragment())
                    .commit()
            } else {
                setContentView(R.layout.activity_main)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment())
                    .commit()
            }
        }
    }
}