package pl.TDN.ToDoNote.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "USERS")
public class UserEntity { //TODO add more attributes and its validators

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String firstName;

    private String secondName;

    private String password;

    private String email;

}
