package pl.TDN.ToDoNote.checklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<CheckListDTO> getAllCheckLists() {
        return checkListService.getAllCheckLists();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckListDTO getCheckListById(@PathVariable Long id) {
        return checkListService.findCheckByListId(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckListDTO addCheckList(@RequestBody CheckListEntity aCheckListEntity) {
        return checkListService.addCheckList(aCheckListEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckListDTO> updateCheckList(@PathVariable Long id, @RequestBody CheckListEntity aCheckListEntity) {
        CheckListDTO updatedCheckList = checkListService.updateCheckList(id, aCheckListEntity);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "CheckList with id"
                + id + " has been updated successfully");

        return new ResponseEntity<>(updatedCheckList, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CheckListDTO> deleteCheckList(@PathVariable Long id){
        checkListService.deleteCheckListById(id);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "CheckList with id " + id + " has been deleted successfully");

        return new ResponseEntity<>(httpHeaders, HttpStatus.ACCEPTED);
    }
}
