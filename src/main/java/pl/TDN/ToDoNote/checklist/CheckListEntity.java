package pl.TDN.ToDoNote.checklist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.TDN.ToDoNote.BasicEntity;
import pl.TDN.ToDoNote.checklist.items.CheckListItem;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CHECKLISTS")
public class CheckListEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany
    @Column(name = "Check_list_id")
    private List<CheckListItem> items;

    private String notes;

    private LocalDateTime modifiedAt;


    private LocalDateTime createdAt;
}
