package pl.TDN.ToDoNote.user.dto;


import lombok.Builder;

public record UserDTO(String login, String firstName, String secondName, String email) { //TODO class or record?

    @Builder
    public UserDTO {
    }
}
