package pl.TDN.ToDoNote.checklist;

import org.springframework.stereotype.Component;
import pl.TDN.ToDoNote.checklist.dto.CheckListDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckListMapper {


    CheckListDTO fromCheckListEntityToCheckListDTO(CheckListEntity aCheckListEntity) {
        return CheckListDTO.builder()
                .id(aCheckListEntity.getId())
                //TODO rest of attributes
                .build();
    }

    List<CheckListDTO> fromCheckListEntityListToCheckListDTO(List<CheckListEntity> aCheckListEntityList) {
        List<CheckListDTO> checkListDTOs = new ArrayList<>();
        for (CheckListEntity checkListEntity : aCheckListEntityList) {
            fromCheckListEntityToCheckListDTO(checkListEntity);
        }
        return checkListDTOs;
    }
}
