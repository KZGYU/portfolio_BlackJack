// パッケージ宣言: このクラスが属するパッケージを指定します。
package com.portfolio.blackjack.entity;

// 必要なインポート: Jakarta Persistence APIとLombokライブラリからのクラスをインポートします。
import jakarta.persistence.Column;//エンティティのフィールドがデータベーステーブルのどのカラムにマッピングされるかを指定するために使用
import jakarta.persistence.Entity;//データベーステーブルの行を表すオブジェクトであることを指定するために使用
import jakarta.persistence.GeneratedValue;//プライマリキーの値がどのように自動生成されるかを指定するために使用
import jakarta.persistence.GenerationType;//@GeneratedValueアノテーションと共に使用され、プライマリキーの生成戦略（IDENTITY、SEQUENCE、TABLEなど）を指定するために使用
import jakarta.persistence.Id;//エンティティクラスのフィールドがテーブルのプライマリキーに対応することを指定するために使用
import jakarta.persistence.Table;//エンティティがどのデータベーステーブルにマッピングされるかを指定するために使用
//Lombokライブラリ
import lombok.Getter;//クラスの各フィールドに対するゲッターメソッドを自動的に生成するために使用
import lombok.Setter;//クラスの各フィールドに対するセッターメソッドを自動的に生成するために使用
import lombok.ToString;//クラスのインスタンスの文字列表現（通常はフィールドの値を含む）を生成するメソッドを自動的に生成するために使用

// @Entityアノテーション: このクラスがエンティティクラスであることを示します。
@Entity
// @Tableアノテーション: このエンティティがマッピングされるデータベーステーブルの名前を指定します。
@Table(name = "tranp")
// Lombokアノテーション: ゲッター、セッター、toStringメソッドを自動生成します。
@Getter
@Setter
@ToString
public class Card {

    // @Idアノテーション: このフィールドがテーブルのプライマリキーであることを示します。
    @Id
    // @GeneratedValueアノテーション: プライマリキーの値が自動生成されることを示します。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Columnアノテーション: このフィールドがマッピングされるテーブルのカラム名を指定します。
    @Column(name = "id")
    private Integer id; // カードの一意のID

    @Column(name = "no")
    private Integer no; // カードの数字 (1～13)
    

    @Column(name = "type")
    private Integer type; // カードの種類 (1:ダイヤ、2:ハート、3:クラブ、4:スペード)

    @Column(name = "image")
    private String image; // カードの画像のパス

    // コンストラクタ、ゲッター、セッター、toStringメソッドはLombokによって自動生成されます。
}
