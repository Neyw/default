package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.TicketDto;

import java.util.Optional;

public interface TicketService {
    Optional<TicketDto> getTicket(long id);

    TicketDto createTicket(TicketDto ticketDto);

    void deleteTicket(long ticketId);
}
