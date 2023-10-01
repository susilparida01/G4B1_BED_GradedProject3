package com.gl.codingassignmnet.tickettrackerapplication.service;

import java.util.List;

import com.gl.codingassignmnet.tickettrackerapplication.entity.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();

	public Ticket save(Ticket ticket);

	public Ticket getTicketById(long ticketId);

	public Ticket updateTicket(long ticketId, Ticket ticket);

	public void deleteTicketById(long ticketId);

	public List<Ticket> search(String searchText);
}
