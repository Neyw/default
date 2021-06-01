package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.CardDataDto;

import java.util.Optional;

public interface CardDataService {
    Optional<CardDataDto> getCardData(long id);

    CardDataDto createCardData(CardDataDto cardData);

    CardDataDto update(CardDataDto cardData);

    void deleteCardData(long cardDataId);
}
