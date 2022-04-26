package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.store.SessionStore;

import java.util.List;

@Service
public class SessionService {
    private final SessionStore sessionStore;

    public SessionService(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public List<Session> findAllSessions() {
        return sessionStore.findAll();
    }
}
