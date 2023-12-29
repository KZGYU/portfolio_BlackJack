package com.portfolio.blackjack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.blackjack.entity.Card;
import com.portfolio.blackjack.service.CardService; 

@Controller
public class BlackjackController {

	private final CardService cardService;
    private List<Card> playerCards;
    private List<Card> dealerCards;

	public BlackjackController(CardService cardService) {
		this.cardService = cardService;
 
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	// スタートボタンを押した後の処理
	@GetMapping("/start")
	public String startGame(Model model) {
        // カード情報を取得してデッキを設定
        List<Card> cards = cardService.findAllCards();
        cardService.setDeck(cards);
		
		//ディーラーとプレイヤーに２枚ずつカードを配る
	    dealerCards = new ArrayList<>();
	    playerCards = new ArrayList<>();
		for (int i=0; i<2;i++) {
			dealerCards.add(cardService.drawCard());
			playerCards.add(cardService.drawCard());
		}
		
		//ゲーム状態をモデルに追加
		model.addAttribute("dealerCards",dealerCards );
		model.addAttribute("playerCards",playerCards );
		return "play"; // playビューに遷移
	}

	@GetMapping("/stay")
	public String stay() {
		// ゲームのロジックをここに実装
		return "win"; // または "lose"
	}

	@GetMapping("/add")
	public String addCard(Model model) {
		//プレイヤーに新しいカードを追加
		Card newCard = cardService.drawCard();
		playerCards.add(newCard);

		//プレイヤーのカードの合計値を計算
		int playerTotal = calculateTotal(playerCards);
		if (playerTotal > 21) {
			model.addAttribute("message", "Bust! You've exceeded21.");
			return "lose";
		}
		
		//ディーラのカードの合計値を計算
		int dealerTotal = calculateTotal(dealerCards);
		while (dealerTotal < 17) {
			Card dealerCard = cardService.drawCard();
			dealerCards.add(dealerCard);
			dealerTotal = calculateTotal(dealerCards);
		}

		//ゲームの状態を更新
		model.addAttribute("playerCards", playerCards);
		model.addAttribute("playerCards", dealerCards);
		model.addAttribute("playerCards", playerTotal);
		model.addAttribute("playerCards", dealerTotal);

		return "play";
	}

	//カードの合計値を計算するロジックを実装
	private int calculateTotal(List<Card> cards) {
		//カードの合計値を計算するロジックを実装
		int total=cards.stream().mapToInt(card -> card.getNo()).sum();
		return total;
	}

	@GetMapping("/lose")
	public String lose() {
		return "lose"; // 敗北画面に遷移
	}
}
