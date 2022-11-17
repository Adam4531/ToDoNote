package pl.TDN.ToDoNote.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.TDN.ToDoNote.note.dto.NoteDTO;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService aNoteService) {
        noteService = aNoteService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NoteDTO> getNotes(){
        return noteService.getAllNotes();
    }


}
