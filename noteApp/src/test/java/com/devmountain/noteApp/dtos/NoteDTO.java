package com.devmountain.noteApp.dtos;
import com.devmountain.noteApp.entities.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO implements Serializable {
    private Long id;
    private String body;
    private UserDTO userDTO;
    public  NoteDTO (Note note){
        if (note.getId() != null){
            this.id = note.getId();
        }
        if (note.getId() != null){
            this.body = note.getBody();
        }
    }
}
