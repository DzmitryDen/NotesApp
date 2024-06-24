package com.hfad.notesapp.ui.login

import android.content.Context
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModel
import com.hfad.notesapp.R
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast

class LoginViewModel : ViewModel() {

    fun checkEmpty(field: EditText?, context: Context?) {
        field?.doAfterTextChanged { text ->
            if (context != null) {
                validatorToast(
                    context,
                    checkEmpty(text),
                    context.getString(R.string.error_not_empty)
                )
            }
        }
    }
}