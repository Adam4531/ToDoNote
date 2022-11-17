package pl.TDN.ToDoNote.checklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.TDN.ToDoNote.checklist.dto.CheckListDTO;

import java.util.List;

@Service
public class CheckListService {

    private final CheckListMapper checkListMapper;
    private final CheckListRepository checkListRepository;

    @Autowired
    CheckListService(CheckListMapper aCheckListMapper, CheckListRepository aCheckListRepository) {
        checkListMapper = aCheckListMapper;
        checkListRepository = aCheckListRepository;
    }

    public List<CheckListDTO> getAllCheckLists() {
        return checkListMapper.fromCheckListEntityListToCheckListDTO(checkListRepository.findAll());
    }
}
