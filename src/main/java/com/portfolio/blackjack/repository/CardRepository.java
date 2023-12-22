// パッケージ宣言: このインターフェースが属するパッケージを指定します。
package com.portfolio.blackjack.repository;

// 必要なインポート: Spring Data JPAからJpaRepositoryをインポートします。
import org.springframework.data.jpa.repository.JpaRepository;

//エンティティクラスのインポート: このリポジトリが扱うエンティティクラスをインポートします。
import com.portfolio.blackjack.entity.Card;

/**
 * TranpRepositoryは、Tranpエンティティに対するデータアクセス操作を提供するリポジトリインターフェースです。
 * JpaRepositoryを継承することで、基本的なCRUD操作が自動的に提供されます。
 * 必要に応じて、カスタムメソッドを定義して特定のデータアクセス要件を実装することができます。
 */
public interface CardRepository extends JpaRepository<Card, Integer> {
	// ここにカスタムメソッドを追加することができます。例: 特定のtypeに基づいてカードを検索するメソッドなど。
}
