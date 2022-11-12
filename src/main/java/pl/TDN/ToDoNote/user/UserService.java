package pl.TDN.ToDoNote.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    UserService(UserRepository aUserRepository, UserMapper aUserMapper) {
        userRepository = aUserRepository;
        userMapper = aUserMapper;
    }
}
