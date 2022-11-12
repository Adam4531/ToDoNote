package pl.TDN.ToDoNote.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "USERS")
public class UserEntity { //TODO add more attributes and its validators

    private String login;

    private String password;

    private String email;

}
