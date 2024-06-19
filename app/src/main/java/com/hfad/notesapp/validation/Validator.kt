package com.hfad.notesapp.validation

import android.content.Context
import android.widget.Toast

fun validatorToast(context: Context?, check: Boolean, error: String) {
    if (check) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}