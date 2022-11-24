package pl.TDN.ToDoNote.note.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public record NoteDTO (Long id, String title, String notes, LocalDateTime modifiedAt, LocalDateTime createdAt){

    @Builder
    public NoteDTO {
    }
}
