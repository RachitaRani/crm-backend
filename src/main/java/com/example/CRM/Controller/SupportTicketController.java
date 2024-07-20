package com.example.CRM.Controller;

import com.example.CRM.Model.SupportTicket;
import com.example.CRM.Service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/support-tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class SupportTicketController {
    @Autowired
    private SupportTicketService supportTicketService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SupportTicket>> getAllSupportTickets() {
        List<SupportTicket> tickets = supportTicketService.getAllSupportTickets();
        return ResponseEntity.ok(tickets);    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<SupportTicket> getSupportTicketById(@PathVariable Long id) {
        SupportTicket supportTicket = supportTicketService.getSupportTicketById(id);
        if (supportTicket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(supportTicket);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<SupportTicket> createSupportTicket(@RequestBody SupportTicket supportTicket) {
        SupportTicket createdTicket = supportTicketService.createSupportTicket(supportTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable Long id, @RequestBody SupportTicket supportTicketDetails) {
        SupportTicket updatedTicket = supportTicketService.updateSupportTicket(id, supportTicketDetails);
        if (updatedTicket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteSupportTicket(@PathVariable Long id) {
        supportTicketService.deleteSupportTicket(id);
        return ResponseEntity.noContent().build();
    }
}
