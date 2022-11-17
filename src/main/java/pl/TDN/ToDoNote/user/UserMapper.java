package pl.TDN.ToDoNote.user;

import org.springframework.stereotype.Component;
import pl.TDN.ToDoNote.user.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDTO fromUserEntitytoUserDTO(UserEntity aUserEntity){
        return UserDTO.builder()
                .firstName(aUserEntity.getFirstName())
                .secondName(aUserEntity.getSecondName())
                .login(aUserEntity.getLogin())
                .email(aUserEntity.getEmail())
                .build();
    }

    public List<UserDTO> fromUserEntityListToUserDTOList(List<UserEntity> aUserEntities){
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity: aUserEntities) {
            userDTOList.add(fromUserEntitytoUserDTO(userEntity));
        }
        return userDTOList;
    }
}
