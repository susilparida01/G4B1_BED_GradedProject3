package com.gl.codingassignmnet.tickettrackerapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.codingassignmnet.tickettrackerapplication.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t FROM Ticket t WHERE t.title LIKE %?1% or t.description LIKE %?1%")
	public List<Ticket> search(String searchText);

}
