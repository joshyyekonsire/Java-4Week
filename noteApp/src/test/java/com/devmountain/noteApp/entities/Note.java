package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Notes")
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Note(NoteDTO noteDto) {
        if (noteDto.getBody() != null){
            this.body = noteDto.getBody();
        }
    }

    public Long getId() {
        return null;
    }

    public String getBody() {
        return null;
    }
}
