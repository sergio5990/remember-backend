package com.github.sergio5990.remember.domain.controller

import com.github.sergio5990.remember.domain.model.Note
import com.github.sergio5990.remember.domain.model.NoteRequest
import com.github.sergio5990.remember.domain.model.createInitNote
import com.github.sergio5990.remember.domain.service.NoteRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/note")
class NoteController(private val repository: NoteRepository) {

    @GetMapping("/find-by-id/{noteId}")
    fun findById(@PathVariable noteId: String): Mono<Note> {
        return repository.findById(noteId)
    }

    @GetMapping("/find-all")
    fun findAll(): Flux<Note> {
        return repository.findAll()
    }

    @DeleteMapping("/delete-by-id/{noteId}")
    fun deleteById(@PathVariable noteId: String): Mono<Void> {
        return repository.deleteById(noteId)
    }

    @PostMapping("/update-by-id/{noteId}")
    fun update(@PathVariable noteId: String, newContent: String): Mono<Note> {
       return repository.findById(noteId)
                .map { it.copy(content = newContent) }
                .flatMap { repository.save(it) }
    }

    @PostMapping("/create")
    fun create(@RequestBody body: NoteRequest): Mono<Note> {
        val note = createInitNote(body.name, body.content)
        return repository.save(note)
    }
}