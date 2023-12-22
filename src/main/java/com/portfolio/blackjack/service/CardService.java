package com.portfolio.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.portfolio.blackjack.entity.Card;
import com.portfolio.blackjack.repository.CardRepository;

@Service
public class CardService {

	private static final Logger logger = LoggerFactory.getLogger(CardService.class);
	private final CardRepository cardRepository;

	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	public List<Card> findAllCards() {
		try {
			List<Card> cards = cardRepository.findAll();
			if (cards == null) {
				logger.error("Failed to retrieve cards. The card list is null.");
				return new ArrayList<>();
			}
			logger.info("Number of retrieved cards: {}", cards.size());
			for (Card card : cards) {
				logger.debug("Card: {}", card); // 各カードの詳細をログ出力
			}
			return cards;
		} catch (Exception e) {
			logger.error("An error occurred while retrieving cards", e);
			return new ArrayList<>();
		}
	}
}
