package com.hfad.notesapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private const val DATE_FORMAT = "dd/MM/yyyy"

fun LocalDate.toSimpleText(): String {
    val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
    return this.format(formatter)
}