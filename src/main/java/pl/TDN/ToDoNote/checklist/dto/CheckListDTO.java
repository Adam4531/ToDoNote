package pl.TDN.ToDoNote.checklist.dto;

import lombok.Builder;

public record CheckListDTO (Long id) { //TODO add more attributes

    @Builder
    public CheckListDTO {
    }
}
