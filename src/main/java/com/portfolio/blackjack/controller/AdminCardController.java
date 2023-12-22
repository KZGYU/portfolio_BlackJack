package com.portfolio.blackjack.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.blackjack.entity.Card;
import com.portfolio.blackjack.repository.CardRepository;

@Controller
@RequestMapping("/admin/Cards") // 基本URLパスはそのまま（必要に応じて変更可能）
public class AdminCardController {

	private final CardRepository cardRepository;

	public AdminCardController(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	@GetMapping // "/admin/Cards"のGETリクエストを処理
	public String index(Model model) {
		List<Card> cards = cardRepository.findAll(); // カード情報を取得
		model.addAttribute("Cards", cards); // モデルにカード情報を追加
		return "index"; // ビュー名を修正（ビューファイルへのパス）
	}
}
