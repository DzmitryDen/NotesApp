package com.hfad.notesapp.repositories

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val APP_PREFERENCES =  "app_pref"
private const val IS_FIRST_LAUNCH = "isFirstLaunch"
private const val EMAIL = "email"

@Singleton
class SharedPreferencesRepository @Inject constructor(@ApplicationContext context: Context) {

    private var preferences: SharedPreferences

    init {
        preferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    }

    fun isFirstLaunch(): Boolean {
        return preferences.getBoolean(IS_FIRST_LAUNCH, true)?:true
    }

    fun setFirstLaunch() {

        preferences.edit {
            putBoolean(IS_FIRST_LAUNCH, false)
        }
    }

    fun getEmail(): String? {
        return preferences.getString(EMAIL, null)
    }

    fun setEmail(email: String) {
        preferences.edit {
            putString(EMAIL, email)
        }
    }
}