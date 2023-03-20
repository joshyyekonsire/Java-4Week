package com.devmountain.noteApp.services;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Override
    @Transactional
    public void addNote(NoteDTO noteDTO, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Note note = new Note(noteDTO);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);

    }
    @Override
    public void addNote(NoteDTO noteDTO, Long userId) {
    }
    @Override
    @Transactional
    public void deleteNoteById(Long noteId){
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }

    @Override
    public void updateNoteById(NoteDTO noteDTO) {

    }

    @Override
    @Transactional
    public void updateNoteById(NoteDTO noteDTO){
        Optional<Note> noteOptional = noteRepository.findById(noteDTO.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDTO.getBody());
            noteRepository.saveAndFlush(note);
        });
    }

    @Override
    public List<NoteDTO> getAllNotesByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note -> new NoteDTO(note)).collect(Collectors.toList());
        }
    }
    public Optional<NoteDTO>(Long noteId){
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        if(noteOptional.isPresent()){

            return Optional.empty();
        }
    }

}
