package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.SessionDBStore;
import ru.job4j.cinema.store.SessionStore;

import java.util.List;

@Service
public class SessionService {

    private final SessionDBStore sessionStore;

    public SessionService(SessionDBStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public List<Session> findAllSessions() {
        return sessionStore.findAll();
    }
}
