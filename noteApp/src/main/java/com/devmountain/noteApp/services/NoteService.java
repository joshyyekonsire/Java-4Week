package com.devmountain.noteApp.services;
import jakarta.transaction.Transactional;

public interface NoteService {
    @Transactional
    void addNote(NoteDTO noteDTO, Long userId);
    @Transactional
    void deleteNoteById(Long noteId);
    @Transactional
    void updateNoteById(NoteDTO noteDTO);
    List<NoteDTO> getAllNotesByUserId(Long userId);
}
