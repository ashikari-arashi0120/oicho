package game;

import java.util.Random;
import java.util.Scanner;

import players.Player;

public class Choice {
    public static int random(){
        Random rand = new Random();
        return rand.nextInt(9)+1;
    }

    //毎ターン使用する一、二枚目の手札の確認と三枚目を引くか確認するメソッドの呼び出しを行うメソッド
    public static void playerChoice(Player p,Scanner scan){
        System.out.println("");
        System.out.println("一枚目：" + p.cards1);
        System.out.println("二枚目：" + p.cards2);
        choice(p,scan);
    }

    //三枚目の手札を引くかどうかの確認
    public static void choice(Player p,Scanner scan){
        Boolean flag = true;
        do{
            System.out.println("");
            System.out.print("三枚目を引きますか？：");
            String answer = scan.next();
            System.out.println("");
            if(answer.equals("はい")){
                p.cards3 = random();
                System.out.println("三枚目：" + p.cards3);
                System.out.println("");
                flag = false;
            }else if(answer.equals("いいえ")){
                flag = false;
            }else{
                System.out.println("「はい」か「いいえ」で選択してください");
            }
        }while(flag);
    }

    //ゲームを続行するかの確認
    public static Boolean continueChoice(Scanner scan){
        System.out.print("ゲームを続けますか？：");
        String choice = scan.next();
        System.out.println("");
        if(choice.equals("はい")){
            System.out.println("-----");
            System.out.println("");
            return true;
        }else if(choice.equals("いいえ")){
            System.out.println("ご利用ありがとうございました");
            System.out.println();
            return false;
        }else{
            System.out.println("「はい」・「いいえ」以外が入力されたのでゲームを続行します");
            System.out.println();
            return true;
        }
    }
    
}
