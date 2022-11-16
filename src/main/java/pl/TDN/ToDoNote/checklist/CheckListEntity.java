package pl.TDN.ToDoNote.checklist;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CHECKLISTS")
public class CheckListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

//    private List<String> thingsToDo; //FIXME should not be a container (?)

    private String notes;

    private LocalDateTime modifiedAt;

//    private List<Boolean> isDone;

    private LocalDateTime createdAt;
}
