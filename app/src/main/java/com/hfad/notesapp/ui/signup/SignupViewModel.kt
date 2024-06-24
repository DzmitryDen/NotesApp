package com.hfad.notesapp.ui.signup

import android.content.Context
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModel
import com.hfad.notesapp.R
import com.hfad.notesapp.validation.validatorToast
import com.hfad.notesapp.validation.checkSignName
import com.hfad.notesapp.validation.checkEmail
import com.hfad.notesapp.validation.checkSignPassword

class SignupViewModel: ViewModel() {

    fun checkSignName(field: EditText?, context: Context?) {
        field?.doAfterTextChanged { text ->
            if (context != null) {
                validatorToast(
                    context,
                    checkSignName(text),
                    context.getString(R.string.error_common)
                )
            }
        }
    }

    fun checkEmail(field: EditText?, context: Context?) {
        field?.doAfterTextChanged { text ->
            if (context != null) {
                validatorToast(
                    context,
                    checkEmail(text),
                    context.getString(R.string.error_common)
                )
            }
        }
    }

    fun checkSignPassword(field: EditText?, context: Context?) {
        field?.doAfterTextChanged { text ->
            if (context != null) {
                validatorToast(
                    context,
                    checkSignPassword(text),
                    context.getString(R.string.error_common)
                )
            }
        }
    }
}