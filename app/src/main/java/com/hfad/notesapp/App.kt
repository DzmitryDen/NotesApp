package com.hfad.notesapp

import android.app.Application
import com.hfad.notesapp.db.DataBaseProvider
import com.hfad.notesapp.repositories.SharedPreferencesRepository

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferencesRepository.init(this)
        DataBaseProvider.init(this)
    }
}