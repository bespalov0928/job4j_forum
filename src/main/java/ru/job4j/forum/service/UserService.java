package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public final List<User> users = new ArrayList<>();


    public List<User> getAllUser() {
        return users;
    }

    public User findByUserName(String username) {
        User rsl = null;
        for (int index = 0; index < users.size(); index++) {
            User temp = users.get(index);
            System.out.println(temp.getUsername());
            if (temp.getUsername().equals(username)) {
                rsl = temp;
            }
        }
        return rsl;
    }

    public void saveUser(User user) {
        users.add(user);
    }
}
