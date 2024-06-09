package com.hfad.notesapp.validation

import android.text.Editable
import android.util.Patterns
import java.util.regex.Pattern

fun checkEmpty(text: Editable?): Boolean {
    return text.isNullOrEmpty() || text.trim().isEmpty()
}

fun checkSignName(text: Editable?): Boolean {
    val lengthString = text.toString().length
    return lengthString < 3 || lengthString > 255
}

fun checkEmail(text: Editable?): Boolean {
    val str = text.toString()
    return !Patterns.EMAIL_ADDRESS.matcher(str).matches()
}

fun checkSignPassword(text: Editable?): Boolean {
    val str = text.toString()
    val lengthString = str.length
    val patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$")
    val matcher = patternPassword.matcher(str)
    return (lengthString < 6 || lengthString > 50) || !matcher.matches()
}