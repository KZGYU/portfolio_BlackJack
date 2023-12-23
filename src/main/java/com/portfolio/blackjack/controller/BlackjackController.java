package com.portfolio.blackjack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.blackjack.service.CardService;

@Controller
public class BlackjackController {

	private final CardService cardService;

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
		// カード情報を取得してモデルに追加
		model.addAttribute("cards", cardService.findAllCards());
		return "play"; // playビューに遷移
	}

	// ゲーム中の処理（カードを追加するなど）
	@GetMapping("/play")
	public String play(Model model) {
		// すべてのカードを取得してモデルに追加
		model.addAttribute("cards", cardService.findAllCards());
		return "play";
	}

	@GetMapping("/stay")
	public String stay() {
		// ゲームのロジックをここに実装
		return "win"; // または "lose"
	}

	@GetMapping("/add")
	public String addCard() {
		// カードを追加するロジックをここに実装
		return "play";
	}

	@GetMapping("/lose")
	public String lose() {
		return "lose"; // 敗北画面に遷移
	}
}
