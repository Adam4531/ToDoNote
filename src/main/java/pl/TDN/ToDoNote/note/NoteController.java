package pl.TDN.ToDoNote.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.TDN.ToDoNote.note.dto.NoteDTO;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController { //TODO

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService aNoteService) {
        noteService = aNoteService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NoteDTO> getNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NoteDTO getNoteById(@PathVariable Long id) {
        return noteService.findNoteById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public NoteDTO addNote(@RequestBody NoteEntity aNoteEntity) {
        return noteService.addNote(aNoteEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @RequestBody NoteEntity aNoteEntity) {
        NoteDTO updatedNote = noteService.updateNote(id, aNoteEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Note with id" + id + " has been updated successfully!");
        return new ResponseEntity<>(updatedNote, httpHeaders, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<NoteDTO> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Note with id" + id + " has been deleted successfully!");
        return new ResponseEntity<>(httpHeaders, HttpStatus.ACCEPTED);
    }

}
