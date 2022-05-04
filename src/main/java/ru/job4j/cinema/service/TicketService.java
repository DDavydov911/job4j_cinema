package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.CinemaHall;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.SessionStore;
import ru.job4j.cinema.store.TicketsDBStore;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final TicketsDBStore ticketStore;
    private final SessionStore sessionStore;
    private final CinemaHall cinemaHall = new CinemaHall();

    public TicketService(TicketsDBStore ticketStore,
                         SessionStore sessionStore) {
        this.ticketStore = ticketStore;
        this.sessionStore = sessionStore;
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketStore.addTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketStore.findAll();
    }

    public List<Ticket> getTicketsBySessionId(int id) {
        return ticketStore.findTicketsBySessionId(id);
    }

    public List<Integer> getAvailableRows(int sessionId) {
        List<Ticket> tickets = getTicketsBySessionId(sessionId);
        List<Integer> availableRows = new ArrayList<>();
        for (int i = 1; i <= cinemaHall.getRows(); i++) {
             availableRows.add(i);
        }
        for (Ticket ticket : tickets) {
            availableRows.remove(ticket.getRow() - 1);
        }
        return availableRows;
    }

    public List<Integer> getAvailableCells(int sessionId, int row) {
        List<Ticket> tickets = getTicketsBySessionId(sessionId);
        List<Integer> availableCells = new ArrayList<>();
        for (int i = 1; i <= cinemaHall.getCells(); i++) {
            availableCells.add(i);
        }
        for (Ticket ticket : tickets) {
            if (ticket.getRow() == row) {
                availableCells.remove(ticket.getCell() - 1);
            }
        }
        return availableCells;
    }

    public List<Session> getAllSessions() {
        return sessionStore.findAll();
    }

    public Ticket bookTicket(Ticket ticket) {
        return ticketStore.addTicket(ticket);
    }
}
