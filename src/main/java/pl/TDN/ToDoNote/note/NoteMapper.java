package pl.TDN.ToDoNote.note;

import org.springframework.stereotype.Component;
import pl.TDN.ToDoNote.note.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteMapper {

    NoteDTO fromNoteEntityToNoteDTO(NoteEntity aNoteEntity){
        return NoteDTO.builder()
                .id(aNoteEntity.getId())
                .title(aNoteEntity.getTitle())
                .notes(aNoteEntity.getNotes())
                .modifiedAt(aNoteEntity.getModifiedAt())
                .createdAt(aNoteEntity.getCreatedAt())
                .build();
    }


    List<NoteDTO> fromNoteEntityListToNoteDTO(List<NoteEntity> aNoteEntityList) {
        List<NoteDTO> noteDTOList = new ArrayList<>();
        for (NoteEntity noteEntity: aNoteEntityList) {
            noteDTOList.add(fromNoteEntityToNoteDTO(noteEntity));
        }
        return noteDTOList;
    }
}
