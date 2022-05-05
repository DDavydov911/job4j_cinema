package ru.job4j.cinema.service;

import ru.job4j.cinema.model.User;
import ru.job4j.cinema.store.UserDBStore;

import java.util.Optional;

public class UserService {

    private final UserDBStore userDBStore;

    public UserService(UserDBStore userDBStore) {
        this.userDBStore = userDBStore;
    }

    public Optional<User> add(User user) {
        return userDBStore.add(user);
    }

    public Optional<User> findUserByEmailAndPwd(String email, String password) {
        return userDBStore.findUserByEmailAndPwd(email, password);
    }
}
