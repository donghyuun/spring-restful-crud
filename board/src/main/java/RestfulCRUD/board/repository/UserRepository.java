package RestfulCRUD.board.repository;

import RestfulCRUD.board.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db연동...
    // JPA 이용해서 ...

    //임시
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("kang", "test1", "1234"));
        users.add(new UserDTO("park", "test2", "1234"));
        users.add(new UserDTO("kim", "test3", "1234"));
    }

    //static 이면 user가 어떤 유저객체인지 모르기 때문에 객체에 종속된 함수여야함 => static 불가
    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }

    //객체에 종속되지 않은 내용(users)에 접근할때는 static 이어야 함
    public static List<UserDTO> getAllUsers() {
        return users;
    }

    public UserDTO getUserByUserId(String userId) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("", "", ""));
    }

    public void updateUserPw(String userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))//해당 id가 있는지 검색
                .findAny()
                .orElse(new UserDTO("", "", ""))//없으면 빈 유저 객체
                .setUserPw(user.getUserPw());//있으면 유저 비밀번호 변경
    }

    public void deleteUser(String userId) {
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));//id 같은 것 있으면 해당 유저 객체 삭제
    }
}
