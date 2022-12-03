package pl.TDN.ToDoNote.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.TDN.ToDoNote.note.dto.NoteDTO;

import java.util.List;

@Service
public class NoteService {

    private final NoteMapper noteMapper;
    private final NoteRepository noteRepository;

    @Autowired
    NoteService(NoteMapper aNoteMapper, NoteRepository aNoteRepository) {
        noteMapper = aNoteMapper;
        noteRepository = aNoteRepository;
    }

    public List<NoteDTO> getAllNotes(){
        return noteMapper.fromNoteEntityListToNoteDTO(noteRepository.findAll());
    }

    NoteEntity getNoteById(Long aId){
        return noteRepository.findById(aId).orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found!"));
    }

    NoteDTO findNoteById(Long aId) { //TODO
         return noteMapper.fromNoteEntityToNoteDTO(getNoteById(aId));
    }

    NoteDTO addNote(NoteEntity aNoteEntity) { //TODO
    }

    NoteDTO updateNote(Long aId, NoteEntity aNoteEntity) { //TODO
        NoteEntity noteEntity = getNoteById(aId);
        noteRepository.save(aNoteEntity);
        return noteMapper.fromNoteEntityToNoteDTO(aNoteEntity);
    }

    void deleteNote(Long aId){ //TODO
        noteRepository.deleteById(aId);
    }
}
