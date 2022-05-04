package ru.job4j.cinema.store;

import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SessionStore {

    private final Map<Integer, Session> sessions = new ConcurrentHashMap();

    public SessionStore() {
        sessions.put(1, new Session(1, "1 + 1"));
        sessions.put(2, new Session(2, "Last from Mohegans"));
        sessions.put(3, new Session(3, "Great Seven"));
    }

    public List<Session> findAll() {
        return new ArrayList<>(sessions.values());
    }

    public static void main(String[] args) {
        SessionStore sessionStore = new SessionStore();
        for (Session session : sessionStore.findAll()) {
            System.out.println(session.getId() + " " + session.getName());
        }
    }

    public Session findById(int id) {
        return sessions.get(id);
    }
}
