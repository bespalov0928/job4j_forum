package ru.job4j.forum.control;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService users;
    private final AuthorityRepository authorities;

    public RegControl(PasswordEncoder encoder, UserService users, AuthorityRepository authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }

    @RequestMapping(value = "/reg", method= RequestMethod.POST)
    public String regSave(@ModelAttribute("user") User user, Model model){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode(user.getPassword());

        user.setEnabled(true);
        user.setPassword(pwd);
        user.setUsername(user.getUsername());
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.saveUser(user);
        return "redirect:/login";
    }


}
