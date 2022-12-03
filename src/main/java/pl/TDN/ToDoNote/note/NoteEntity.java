package pl.TDN.ToDoNote.note;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.TDN.ToDoNote.BasicEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "NOTES")
public class NoteEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String notes;

    private LocalDateTime modifiedAt;

    private LocalDateTime createdAt;
}
