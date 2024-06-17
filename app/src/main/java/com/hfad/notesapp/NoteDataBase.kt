package com.hfad.notesapp

object NoteDataBase {

    val noteList = arrayListOf<Any>(
        Note(
            title = "Title (hard code) ",
            message = "Test text message.  Test text message. Test text message. Test text message. Test text message. Test text message."
        ),

        ScheduledNote(
            title = "Title Scheduled(hard code)",
            message = "Text Scheduled(hard code)",
            date = "05/11/1973"
        )
    )
}