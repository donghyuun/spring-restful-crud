package RestfulCRUD.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller 와 @ResponseBody 기능을 합친 것
@RequestMapping("/")
public class HomeController {

    @GetMapping("")//root url로 GET 요청을 받았을때
    public String test() {
        return "test!!!";
    }
}
