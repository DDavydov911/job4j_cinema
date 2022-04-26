package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.SessionDBStore;
import ru.job4j.cinema.store.SessionStore;
import ru.job4j.cinema.store.TicketsDBStore;

import java.util.List;

@Service
public class TicketService {

    private final TicketsDBStore ticketStore;

    private final SessionStore sessionStore;

    public TicketService(TicketsDBStore ticketStore, SessionStore sessionStore) {
        this.ticketStore = ticketStore;
        this.sessionStore = sessionStore;
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketStore.addTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketStore.findAll();
    }

    public List<Integer> getAvailableRows() {
        return null;
    }

    public List<Integer> getAvailableCells() {
        return null;
    }

    public List<Session> getAllSessions() {
        return sessionStore.findAll();
    }

    public List<Session> getAvailableSessions() {
        return null;
    }
}
