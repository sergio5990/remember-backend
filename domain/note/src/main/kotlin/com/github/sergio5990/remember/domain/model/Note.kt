package com.github.sergio5990.remember.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "notes")
data class Note(@Id val id: String? = null,
                val name: String,
                val content: String,
                val owner: Long,
                val catalogId: String,
                val metaData: MutableMap<String, Any>,
                val created: LocalDateTime,
                val latsUpdate: LocalDateTime,
                val priority: Int = 0)

data class NoteRequest(val name: String, val content: String)

fun createInitNote(name: String, content: String): Note {
    return Note(name = name,
            content = content,
            catalogId = "1",
            created = LocalDateTime.now(),
            latsUpdate = LocalDateTime.now(),
            metaData = mutableMapOf(),
            owner = 1L,
            priority = 0)
}