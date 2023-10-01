package com.gl.codingassignmnet.tickettrackerapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.codingassignmnet.tickettrackerapplication.entity.Ticket;
import com.gl.codingassignmnet.tickettrackerapplication.service.TicketService;

@Controller
@RequestMapping("/admin/tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping
	public String getAllTickets(Model model) {
		model.addAttribute("tickets", ticketService.getAllTickets());
		return "list_tickets";
	}

	@GetMapping("/newTicket")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}

	@PostMapping("/newTicket")
	public String save(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/admin/tickets";
	}

	@GetMapping("{id}/edit")
	public String editTicket(@PathVariable long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		if (ticket != null) {
			model.addAttribute("ticket", ticket);
			return "edit_ticket";
		}
		return "redirect:/admin/tickets";
	}

	@PostMapping("{id}/edit")
	public String update(@PathVariable long id, @ModelAttribute("ticket") Ticket ticket) {
		if (ticketService.updateTicket(id, ticket) != null) {
			return "redirect:/admin/tickets";
		}
		return "edit_ticket";
	}

	@GetMapping("{id}/view")
	public String viewTicket(@PathVariable long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		if (ticket != null) {
			model.addAttribute("ticket", ticket);
			return "view_ticket";
		}
		return "redirect:/admin/tickets";
	}

	@PostMapping("{id}/delete")
	public String deleteTicket(@PathVariable long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/search")
	public String search(@RequestParam("query") String searchQuery, Model model) {
		if (!searchQuery.isBlank()) {
			model.addAttribute("searchText", searchQuery);
			model.addAttribute("tickets", ticketService.search(searchQuery));
			return "list_tickets";
		}
		return "redirect:/admin/tickets";
	}
}
