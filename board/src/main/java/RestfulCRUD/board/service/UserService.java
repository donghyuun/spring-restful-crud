package RestfulCRUD.board.service;

import RestfulCRUD.board.dto.UserDTO;
import RestfulCRUD.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired//계층간 통신을 위한 의존성 설정
    UserRepository userRepository;

    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers() {
        return UserRepository.getAllUsers();//클래스 이름을 이용해 static 메서드를 호출
    }

    public UserDTO getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    public void updateUserPw(String userId, UserDTO user) {
        userRepository.updateUserPw(userId, user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }
}
