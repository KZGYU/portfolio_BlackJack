//http://localhost:8080/

package com.portfolio.blackjack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlackjackController {

	@GetMapping("/")
	public String index() {
		// 初期画面を表示
		return "index";
	}

	@GetMapping("/start")
	public String startGame() {
		// ゲーム開始時の画面を表示
		return "play";
	}

	@GetMapping("/stay")
	public String stay() {
		// プレイヤーが「stay」を選択した時の処理
		// 実際のゲームロジックはここに実装します
		return "win"; // 仮に勝利画面を表示
	}

	@GetMapping("/add")
	public String addCard() {
		// プレイヤーがカードを追加する時の処理
		// 実際のゲームロジックはここに実装します
		return "play"; // ゲーム続行の画面を表示
	}
}
