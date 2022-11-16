package pl.TDN.ToDoNote.note;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "NOTES")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

//    private List<String> thingsToDo;

    private String notes;

    private LocalDateTime modifiedAt;

    private LocalDateTime createdAt;
}