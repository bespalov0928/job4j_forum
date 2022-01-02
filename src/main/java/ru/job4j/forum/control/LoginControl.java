package ru.job4j.forum.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class LoginControl {

    private final UserService users;

    public LoginControl(UserService users) {
        this.users = users;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessage = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logoutPage(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User rsl = users.findByUserName(username);
        System.out.println("rsl: " + rsl);
        String errorMessage = null;
        if (rsl == null) {
            System.out.println("userName: " + username);
            errorMessage = "user is not in the database !!";
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }if (rsl != null & !rsl.getPassword().equals(password)){
            System.out.println("password: " + password);
            errorMessage = "password does not match !!";
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }

        return "redirect:/index";
    }

}
