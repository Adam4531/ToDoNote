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

    UserEntity getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User Does not exist"));
    }

    UserDTO findUserById(Long aId) {
        UserEntity user = getUserById(aId);
        return userMapper.fromUserEntitytoUserDTO(user);
    }

    UserDTO addUser(UserEntity aUserEntity) {
        UserEntity savedUser = userRepository.save(aUserEntity);
        return userMapper.fromUserEntitytoUserDTO(savedUser);
    }

    UserDTO updateUser(Long aId, UserEntity aUserEntity) {
        UserEntity user = getUserById(aId);
        UserEntity updatedUser = userRepository.save(aUserEntity);
        return userMapper.fromUserEntitytoUserDTO(updatedUser);
    }

    void deleteUser(Long aId) {
        userRepository.deleteById(aId);
    }
}
