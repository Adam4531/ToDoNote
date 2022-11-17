package pl.TDN.ToDoNote.checklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.TDN.ToDoNote.checklist.dto.CheckListDTO;

import java.util.List;

@RestController
@RequestMapping("/checklists")
public class CheckListController {

    private final CheckListService checkListService;

    @Autowired
    public CheckListController(CheckListService aCheckListService) {
        checkListService = aCheckListService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CheckListDTO> getCheckLists(){
        return checkListService.getAllCheckLists();
    }
}
