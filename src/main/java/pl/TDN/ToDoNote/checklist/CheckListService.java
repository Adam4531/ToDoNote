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

    public CheckListEntity getCheckListById(Long id){
        return checkListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("CheckList with id: " + id
                + " not found"));
    }


    public CheckListDTO findCheckByListId(Long id) { //FIXME Required type Checklist
        CheckListEntity checkListEntity = getCheckListById(id);
        return checkListMapper.fromCheckListEntityToCheckListDTO(checkListEntity);
    }


    public CheckListDTO addCheckList(CheckListEntity aCheckListEntity) {
        checkListRepository.save(aCheckListEntity);
        return checkListMapper.fromCheckListEntityToCheckListDTO(aCheckListEntity);
    }

    public CheckListDTO updateCheckList(Long aId, CheckListEntity aCheckListEntity) {
        CheckListEntity checkListEntity = getCheckListById(aId);
        checkListRepository.save(aCheckListEntity);
        return checkListMapper.fromCheckListEntityToCheckListDTO(aCheckListEntity);
    }

    public void deleteCheckListById(Long aId) {
        checkListRepository.deleteById(aId);
    }
}
