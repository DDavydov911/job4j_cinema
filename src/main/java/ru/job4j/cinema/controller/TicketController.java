package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.service.TicketService;

@Controller
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/setRows")
    public String setSessions(@ModelAttribute Ticket ticket,
                              Model model) {
        model.addAttribute("ticket", ticket);
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
    public String finish(@ModelAttribute Ticket ticket,
                         Model model) {
        ticket.setId(0);
        System.out.println(ticket.getId());
        ticketService.bookTicket(ticket);
        model.addAttribute("ticket", ticket);
        if (ticket.getId() != 0) {
            return "finishOk";
        }
        return "finishFailed";
    }

    @GetMapping("/finish")
    public String finish(Model model) {
        return "finishOk";
    }
}

