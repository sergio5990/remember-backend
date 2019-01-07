package com.github.sergio5990.remember.domain.service

import com.github.sergio5990.remember.domain.model.Note

interface NoteRepository : ReactiveMongoRepository<Note, String> {

}