package com.hfad.notesapp.validation

import android.text.Editable
import android.util.Patterns
import java.util.regex.Pattern

private const val MIN_LENGTH_SIGN_NAME = 3
private const val MAX_LENGTH_SIGN_NAME = 255
private const val MIN_LENGTH_SIGN_PASSWORD = 6
private const val MAX_LENGTH_SIGN_PASSWORD = 50
private const val PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$"

fun checkEmpty(text: Editable?): Boolean {
    return text.isNullOrEmpty() || text.trim().isEmpty()
}

fun checkSignName(text: Editable?): Boolean {
    val lengthString = text.toString().length
    return lengthString < MIN_LENGTH_SIGN_NAME || lengthString > MAX_LENGTH_SIGN_NAME
}

fun checkEmail(text: Editable?): Boolean {
    val str = text.toString()
    return !Patterns.EMAIL_ADDRESS.matcher(str).matches()
}

fun checkSignPassword(text: Editable?): Boolean {
    val str = text.toString()
    val lengthString = str.length
    val patternPassword = Pattern.compile(PASSWORD_PATTERN)
    val matcher = patternPassword.matcher(str)
    return (lengthString < MIN_LENGTH_SIGN_PASSWORD || lengthString > MAX_LENGTH_SIGN_PASSWORD) || !matcher.matches()
}