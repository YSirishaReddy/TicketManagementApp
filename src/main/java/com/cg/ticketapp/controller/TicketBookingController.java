package com.cg.ticketapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ticketapp.entities.Ticket;
import com.cg.ticketapp.exceptionhandler.RecordAlreadyPresentException;
import com.cg.ticketapp.exceptionhandler.TicketNotFoundException;
import com.cg.ticketapp.service.TicketBookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/api")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@ApiOperation(value = "Creates a new ticket.")
	@PostMapping(value = "/create", consumes = { "application/json", "application/xml" })
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		try {
			Ticket ticket1 = ticketBookingService.createTicket(ticket);
			return new ResponseEntity<Ticket>(ticket1, HttpStatus.CREATED);

		} catch (RecordAlreadyPresentException e) {
			e.printStackTrace();
			return new ResponseEntity<Ticket>(HttpStatus.CONFLICT);

		}

	}

	@ApiOperation(value = "get a ticket by id .")
	@GetMapping(value = "v1/ticket/{ticketId}")
	public ResponseEntity<?> getTicketById(@PathVariable("ticketId") Integer ticketId) throws TicketNotFoundException {
		return ticketBookingService.getTicketById(ticketId);
	}

	@ApiOperation(value = "fetch all Tickets.")
	@GetMapping(value = "v1/ticket/alltickets")
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingService.getAllBookedTickets();
	}

}
