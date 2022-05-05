package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.CinemaHall;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.TicketsDBStore;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final TicketsDBStore ticketStore;
    private final CinemaHall cinemaHall = new CinemaHall();

    public TicketService(TicketsDBStore ticketStore) {
        this.ticketStore = ticketStore;
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketStore.addTicket(ticket);
    }

    public List<Integer> getAvailableRows(int sessionId) {
        List<Ticket> tickets = ticketStore.findTicketsBySessionId(sessionId);
        List<Integer> availableRows = new ArrayList<>();
        for (int i = 1; i <= cinemaHall.getRows(); i++) {
            availableRows.add(i);
        }
        for (Ticket ticket : tickets) {
            if (getAvailableCells(sessionId, ticket.getRow()).isEmpty()) {
                availableRows.remove(Integer.valueOf(ticket.getRow()));
            }
        }
        return availableRows;
    }

    public List<Integer> getAvailableCells(int sessionId, int row) {
        List<Ticket> tickets = ticketStore.findTicketsBySessionId(sessionId);
        List<Integer> availableCells = new ArrayList<>();
        for (int i = 1; i <= cinemaHall.getCells(); i++) {
            availableCells.add(i);
        }
        for (Ticket ticket : tickets) {
            if (ticket.getRow() == row) {
                availableCells.remove(Integer.valueOf(ticket.getCell()));
            }
        }
        for (Integer availableCell : availableCells) {
            System.out.print(availableCell + " ");
        }
        return availableCells;
    }

    public Ticket bookTicket(Ticket ticket) {
        return ticketStore.addTicket(ticket);
    }
}
