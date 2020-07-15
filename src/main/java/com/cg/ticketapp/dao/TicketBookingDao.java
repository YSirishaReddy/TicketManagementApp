package com.cg.ticketapp.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.ticketapp.entities.Ticket;

public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {

	Optional<Ticket> findById(Integer ticketId);

	

}
