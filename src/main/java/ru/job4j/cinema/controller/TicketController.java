package ru.job4j.cinema.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.service.TicketService;
import ru.job4j.cinema.store.SessionStore;

//@Controller
public class TicketController {

    private final TicketService ticketService;
    private final SessionStore sessionStore;

    public TicketController(TicketService ticketService, SessionStore sessionStore) {
        this.ticketService = ticketService;
        this.sessionStore = sessionStore;
    }

//    @GetMapping("/sessions")
//    public String sessions(Model model) {
//        model.addAttribute("sessions", sessionStore.findAll());
////        model.addAttribute("rows", ticketService.getAvailableRows());
////        model.addAttribute("cells", ticketService.getAvailableCells());
//        return "sessions";
//    }

//    @PostMapping("/index")
//    public String addAttributes(@ModelAttribute Session session,
//                                @ModelAttribute String row,
//                                @ModelAttribute String cell) {
//        return "index";
//    }
}

