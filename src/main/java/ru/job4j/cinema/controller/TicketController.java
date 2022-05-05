package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.TicketService;

@Controller
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
/*
    private void printTicket(Ticket ticket) {
        System.out.println("id: " + ticket.getId() + " "
                + "sessionId " + ticket.getSessionId() + " "
                + "row: " + ticket.getRow() + " "
                + "cell: " + ticket.getCell() + " "
                + "userId: " + ticket.getUserId());
    }

 */

    @PostMapping("/setRows")
    public String setSessions(@ModelAttribute Ticket ticket,
                              Model model) {
        model.addAttribute("ticket", ticket);
        /*printTicket(ticket);*/
        model.addAttribute("rows", ticketService.getAvailableRows(
                ticket.getSessionId())
        );
        return "rows";
    }

    @PostMapping("/setCells")
    public String getCells(@ModelAttribute Ticket ticket,
                           Model model) {
        model.addAttribute("ticket", ticket);
        model.addAttribute("cells", ticketService.getAvailableCells(
                ticket.getSessionId(), ticket.getRow())
        );
        return "cells";
    }

    @PostMapping("/finish")
    public String finish(@ModelAttribute Ticket ticket) {
        /*System.out.println(ticket.getId());*/
        Ticket ticketWithId = ticketService.bookTicket(ticket);
        /*System.out.println(ticketWithId.getId());*/
        if (ticket.getId() != 0) {
            return "finishOk";
        }
        return "finishFailed";
    }

    @GetMapping("/finish")
    public String finish() {
        return "finishOk";
    }
}

