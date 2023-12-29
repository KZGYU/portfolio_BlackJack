package com.portfolio.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.portfolio.blackjack.entity.Card;
import com.portfolio.blackjack.repository.CardRepository;

@Service
public class CardService {

    private List<Card> deck; // デッキを表すカードのリスト
    private Random random = new Random(); // ランダムなカードを選択するためのRandomインスタンス

    private static final Logger logger = LoggerFactory.getLogger(CardService.class);
    private final CardRepository cardRepository; // カードリポジトリのインスタンス

    // コンストラクタでCardRepositoryを注入
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    // デッキを設定するメソッド
    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    // カードを1枚引くメソッド
    public Card drawCard() {
        if (deck==null || deck.isEmpty()) {
            // デッキが空の場合は、新しいデッキを生成する
            deck = findAllCards();
        }
        int index = random.nextInt(deck.size()); // ランダムなインデックスを選択
        return deck.remove(index); // デッキからカードを削除し、そのカードを返す
    }

    // すべてのカードを取得するメソッド
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
