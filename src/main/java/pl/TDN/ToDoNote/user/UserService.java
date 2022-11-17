package pl.TDN.ToDoNote.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.TDN.ToDoNote.user.dto.UserDTO;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    UserService(UserRepository aUserRepository, UserMapper aUserMapper) {
        userRepository = aUserRepository;
        userMapper = aUserMapper;
    }

    public List<UserDTO> getAllUsers(){
        return userMapper.fromUserEntityListToUserDTOList(userRepository.findAll());
    }
}
