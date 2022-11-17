package pl.TDN.ToDoNote.note.dto;

import lombok.Builder;

public record NoteDTO (Long id){ //TODO add more attributes

    @Builder
    public NoteDTO {
    }
}
