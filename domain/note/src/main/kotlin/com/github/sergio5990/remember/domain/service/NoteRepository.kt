package com.github.sergio5990.remember.domain.service

import com.github.sergio5990.remember.domain.model.Note
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface NoteRepository : ReactiveMongoRepository<Note, String> {

}