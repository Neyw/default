package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.CardDataMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CardDataDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.CardDataRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.CardDataService;

import java.util.Optional;

@Service
public class CardDataServiceImpl implements CardDataService {
    @Autowired
    private CardDataRepository cardDataRepository;
    @Autowired
    private CardDataMapper cardDataMapper;

    @Override
    public Optional<CardDataDto> getCardData(long id) {
        return cardDataRepository.findById(id)
                .map(cardDataMapper::entityToDto);
    }

    @Override
    public CardDataDto createCardData(CardDataDto cardData) {
        return cardDataMapper.entityToDto(cardDataRepository.save(cardDataMapper.dtoToEntity(cardData)));
    }

    @Override
    public CardDataDto update(CardDataDto cardData) {
        return cardDataMapper.entityToDto(cardDataRepository.save(cardDataMapper.dtoToEntity(cardData)));
    }

    @Override
    public void deleteCardData(long cardDataId) {
        cardDataRepository.deleteById(cardDataId);
    }
}
