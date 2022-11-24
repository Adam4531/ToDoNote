package pl.TDN.ToDoNote.checklist.items;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.TDN.ToDoNote.BasicEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CHECK_LIST_ITEMS")
public class CheckListItem extends BasicEntity {

    private String notes;
    private boolean isDone;

}
