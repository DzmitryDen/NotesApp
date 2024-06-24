package com.hfad.notesapp.ui.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hfad.notesapp.R
import com.hfad.notesapp.ui.mainfragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}