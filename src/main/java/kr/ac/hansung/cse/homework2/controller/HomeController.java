package kr.ac.hansung.cse.homework2.controller;

import kr.ac.hansung.cse.homework2.entity.MyUser;
import kr.ac.hansung.cse.homework2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/adminhome")
    public String adminHome(Model model) {
        List<MyUser> users = userService.userList();
        model.addAttribute("users", users);

        return "adminhome";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) String username,
                            @RequestParam(required = false) String message,
                            Model model) {
        model.addAttribute("username", username);
        model.addAttribute("message", message);
        return "login";
    }

}
