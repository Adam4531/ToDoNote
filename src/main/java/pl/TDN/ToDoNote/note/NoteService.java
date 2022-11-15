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

    public List<NoteDTO> getAll(){
        return noteMapper.fromNoteEntityListToNoteDTO(noteRepository.findAll());
    }
}
