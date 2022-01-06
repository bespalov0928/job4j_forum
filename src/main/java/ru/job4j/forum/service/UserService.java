package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
    private static AtomicInteger USER_COUNT = new AtomicInteger(0);
    public final Map<Integer, User> users = new HashMap<Integer, User>();


    public List<User> getAllUser() {
        List valueList = new ArrayList(users.values());
        return valueList;
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
        users.put(USER_COUNT.getAndIncrement(), user);
    }
}