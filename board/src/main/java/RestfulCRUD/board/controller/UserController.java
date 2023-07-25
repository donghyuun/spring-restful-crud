package RestfulCRUD.board.controller;

import RestfulCRUD.board.dto.UserDTO;
import RestfulCRUD.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller 와 @ResponseBody 기능을 합친 것
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    //CRUD
    //C -> POST
    //R -> GET
    //U -> PUT
    //D -> DELETE

    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user) {//RequestBody를 UserDTO 형태로 받아오겠다는 말
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserByUserId(@PathVariable String userId) {//{userId}의 userId 값이 파라미터의 userId 에 매핑되어 들어간다
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")//하나의 URL로 여러 서비스를 제공할 수 있음
    public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
        userService.updateUserPw(userId, user);//userId가 일치하는 유저에 user객체의 pw를 이용해 기존의 pw를 변경
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}
