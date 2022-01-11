package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.AuthorityRepository;
import ru.job4j.forum.store.UserRepository;

@Service
public class UserService {
    private final UserRepository users;
    private final AuthorityRepository authorities;

    public UserService(UserRepository users, AuthorityRepository authorities) {
        this.users = users;
        this.authorities = authorities;
    }

    public void saveUser(User user, String role) {
        user.setAuthority(authorities.findByAuthority(role));
        users.save(user);

    }
}