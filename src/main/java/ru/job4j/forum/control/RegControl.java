package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {

    private final UserService users;

    public RegControl(UserService users) {
        this.users = users;
    }

    @GetMapping("/reg")
    public String regPage(){
        return "reg";
    }

    @RequestMapping(value = "/reg", method= RequestMethod.POST)
    public String regSave(@ModelAttribute("user") User user, Model model){
        User username = users.findByUserName(user.getUsername());
        System.out.println("UserName: " + user.getUsername());
        System.out.println("user: " + user);
        String errorMessage = null;
        if (username != null){
            System.out.println("userName: "+username);
            errorMessage = "user is already registered !!";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        }
        user.setPassword(user.getPassword());
        user.setUsername(user.getUsername());
        users.saveUser(user);
        return "redirect:/login";

    }


}
