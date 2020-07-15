package com.cg.ticketapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ticketapp.dao.TicketBookingDao;
import com.cg.ticketapp.entities.Ticket;
import com.cg.ticketapp.exceptionhandler.TicketNotFoundException;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public ResponseEntity<?> getTicketById(Integer ticketId) throws TicketNotFoundException {
		Optional<Ticket> ticket = ticketBookingDao.findById(ticketId);
		if (!ticket.isPresent()) {
			throw new TicketNotFoundException("User with given id not found");
		}
		return new ResponseEntity<>(ticket, HttpStatus.OK);

	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

}
