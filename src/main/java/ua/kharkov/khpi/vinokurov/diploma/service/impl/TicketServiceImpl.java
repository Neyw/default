package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.TicketMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.TicketDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.TicketRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.TicketService;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public Optional<TicketDto> getTicket(long id) {
        return ticketRepository.findById(id)
                .map(ticketMapper::entityToDto);
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        return ticketMapper.entityToDto(ticketRepository.save(ticketMapper.dtoToEntity(ticketDto)));
    }

    @Override
    public void deleteTicket(long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
