package com.gl.codingassignmnet.tickettrackerapplication.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.codingassignmnet.tickettrackerapplication.entity.Ticket;
import com.gl.codingassignmnet.tickettrackerapplication.repository.TicketRepository;
import com.gl.codingassignmnet.tickettrackerapplication.service.TicketService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(long ticketId) {
		Ticket ticket = null;
		try {
			ticket = ticketRepository.findById(ticketId).get();
		} catch (IllegalArgumentException | NoSuchElementException ex) {
			log.info("No Ticket Details available for provided ticket id: " + ticketId);
		}
		return ticket;
	}

	@Override
	public Ticket updateTicket(long ticketId, Ticket ticket) {
		Ticket existingTicket = getTicketById(ticketId);
		if (existingTicket != null) {
			existingTicket.setTitle(ticket.getTitle());
			existingTicket.setContent(ticket.getContent());
			existingTicket.setDescription(ticket.getDescription());
			ticketRepository.save(existingTicket);
		}
		return existingTicket;
	}

	@Override
	public void deleteTicketById(long ticketId) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
		}
	}

	@Override
	public List<Ticket> search(String searchText) {
		return ticketRepository.search(searchText);
	}

}
