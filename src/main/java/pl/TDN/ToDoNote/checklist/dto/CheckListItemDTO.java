package pl.TDN.ToDoNote.checklist.dto;

import lombok.Builder;

public record CheckListItemDTO(String notes, boolean isDone) {

    @Builder
    public CheckListItemDTO {
    }
}
