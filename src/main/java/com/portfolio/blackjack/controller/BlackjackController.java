package com.portfolio.blackjack.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // 正しいModelクラスをインポート
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.blackjack.entity.Card;
import com.portfolio.blackjack.service.CardService;  // CardServiceをインポート

@Controller
public class BlackjackController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlackjackController.class);
	
    private final CardService cardService;  // インスタンス変数名を統一

    // コンストラクタ...
    public BlackjackController(CardService cardService) {
        this.cardService = cardService;  // コンストラクタのパラメータ名とインスタンス変数名を統一
    }	   

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/start")
    public String startGame() {
        return "play";
    }

    @GetMapping("/play")
    public String play(Model model) {
        List<Card> cards = cardService.findAllCards();
        logger.info("Retrieved cards: {}", cards); // ログ出力
        model.addAttribute("cards", cards);
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
