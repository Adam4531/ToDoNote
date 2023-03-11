package pl.TDN.ToDoNote.checklist;

import org.springframework.stereotype.Component;
import pl.TDN.ToDoNote.checklist.dto.CheckListDTO;
import pl.TDN.ToDoNote.checklist.dto.CheckListItemDTO;
import pl.TDN.ToDoNote.checklist.items.CheckListItem;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckListMapper {



    CheckListDTO fromCheckListEntityToCheckListDTO(CheckListEntity aCheckListEntity) {
        return CheckListDTO.builder()
                .id(aCheckListEntity.getId())
                .items(fromCheckListItemListToCheckListItemDtoList(aCheckListEntity.getItems()))
                .notes(aCheckListEntity.getNotes())
                .modifiedAt(aCheckListEntity.getModifiedAt())
                .createdAt(aCheckListEntity.getCreatedAt())
                .build();
    }

    List<CheckListDTO> fromCheckListEntityListToCheckListDTO(List<CheckListEntity> aCheckListEntityList) {
        List<CheckListDTO> checkListDTOs = new ArrayList<>();
        for (CheckListEntity checkListEntity : aCheckListEntityList) {
            checkListDTOs.add(fromCheckListEntityToCheckListDTO(checkListEntity));
        }
        return checkListDTOs;
    }

    CheckListItemDTO fromCheckListItemToCheckList(CheckListItem aCheckListItem){
        return CheckListItemDTO.builder()
                .notes(aCheckListItem.getNotes())
                .isDone(aCheckListItem.isDone())
                .build();
    }

    List<CheckListItemDTO> fromCheckListItemListToCheckListItemDtoList(List<CheckListItem> aCheckListItems){
        List<CheckListItemDTO> checkListItemsDto = new ArrayList<>();
        for (CheckListItem checkListItem: aCheckListItems) {
            checkListItemsDto.add(fromCheckListItemToCheckList(checkListItem));
        }
        return checkListItemsDto;
    }
}
