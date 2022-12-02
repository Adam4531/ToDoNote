package pl.TDN.ToDoNote.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.TDN.ToDoNote.user.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService aUserService) {
        userService = aUserService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserEntity aUserEntity) {
        return userService.addUser(aUserEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserEntity aUserEntity) {
        UserDTO user = userService.updateUser(id, aUserEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "User with id: " + id + " has been successfully updated");

        return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "User with id: " + id + " has been successfully deleted");

        return new ResponseEntity<>(httpHeaders, HttpStatus.ACCEPTED);
    }
}
