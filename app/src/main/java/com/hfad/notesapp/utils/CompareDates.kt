package com.hfad.notesapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun compareDates(dateString1: String, dateString2: String): Int {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date1 = dateFormat.parse(dateString1)
    val date2 = dateFormat.parse(dateString2)

    return when {
        date1.before(date2) -> 1
        date1.after(date2) -> 2
        else -> 0
    }
}