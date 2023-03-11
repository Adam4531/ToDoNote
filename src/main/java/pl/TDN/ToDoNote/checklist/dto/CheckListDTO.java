package pl.TDN.ToDoNote.checklist.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record CheckListDTO (Long id, List<CheckListItemDTO> items, String notes, LocalDateTime modifiedAt, LocalDateTime createdAt) {

    @Builder
    public CheckListDTO {
    }
}
