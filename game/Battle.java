package game;

import java.util.Scanner;

import players.Computer;
import players.Player;

public class Battle {

    //通常の勝負のメソッド
    public static void battle(int com,int player,String comName){
        System.out.println("プレイヤー：" + name(player));
        System.out.println(comName + "：" + name(com));
        System.out.println("");
        if(com == player){
            System.out.println("引き分け");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
        }else if(com > player){
            System.out.println(comName + "の勝利");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
        }else{
            System.out.println("プレイヤーの勝利");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
        }
    }

    //プレイヤーが親かつアラシだった場合、全コンピュータとアラシか比べるメソッド
    public static Boolean playerParentArashi(String[] comRole,Computer[] coms,Player p,String player,Scanner scan){
        int i = 0;
        for(String cr : comRole){
            if(cr.equals("アラシ")){
                judge(coms[i++], p, player);
            }else{
                playerArashi();
            }
        }
        return Choice.continueChoice(scan);
    }

    //プレイヤーが子かつアラシだった場合、コンピュータとアラシか比べるメソッド
    public static Boolean playerChildArashi(String comRole,Computer c,Player p,String player,Scanner scan){
        if(comRole.equals("アラシ")){
            judge(c, p, player);
        }else{
            playerArashi();
        }
        return Choice.continueChoice(scan);
    }

    //プレイヤーが親でアラシでなかった場合のメソッド
    public static Boolean playerParentNonArashi(String playerRole,String[] comRole,Computer[] computers,Player p,Scanner scan){
        int i = 0;
        for(Computer c : computers){
            if(playerRole.equals("クッピン")||playerRole.equals("シッピン")){
                cuppinOrShippin(playerRole,comRole[i],c);
            }else{
                System.out.println(c.name + "と勝負！");
                Battle.battle(c.result(),p.result(),c.name);
            }
            i++;
        }
        return Choice.continueChoice(scan);
    }

    //プレイヤーが子でアラシでなかった場合のメソッド
    public static Boolean playerChildNonArashi(String comRole,Computer c,Player p,Scanner scan){
        if(comRole.equals("アラシ")){
            comArashi(c);
        }else{
            battle(c.result(), p.result(), c.name);
        }
        return Choice.continueChoice(scan);
    }

    //プレイヤーがクッピンまたはシッピンの場合のメソッド
    public static void cuppinOrShippin(String playRole,String comRole,Computer c){
        if(comRole.equals("アラシ")){
            comArashi(c);
        }else if(playRole.equals("クッピン")){
            System.out.println("プレイヤー：クッピン");
            System.out.println("プレイヤーの勝利");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
        }else{
            System.out.println("プレイヤー：シッピン");
            System.out.println("プレイヤーの勝利");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
        }
    }

    //プレイヤーがアラシで勝利した場合のメソッド
    public static void playerArashi(){
            System.out.println("プレイヤー：アラシ");
            System.out.println("プレイヤーの勝利");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
    }

    //コンピュータがアラシで勝利した場合のメソッド
    public static void comArashi(Computer c){
            System.out.println(c.name + "：アラシ");
            System.out.println(c.name + "の勝利");
            System.out.println("");
            System.out.println("-----");
            System.out.println("");
    }

    //プレイヤーもコンピュータもアラシだった場合のメソッド
    public static void judge(Computer c,Player p,String player){
        if(player.equals("親")){
            if(c.cards1 == p.cards1){
                playerArashi();
            }else if(c.cards1 > p.cards1){
                comArashi(c);
            }else{
                playerArashi();
            }
        }else{
            if(c.cards1 == p.cards1){
                comArashi(c);
            }else if(c.cards1 > p.cards1){
                comArashi(c);
            }else{
                playerArashi();
            }
        }
    }

    //各数字の名称を返すメソッド
    public static  String name(int num){
        switch(num){
            case 0:
                return "ブタ";
            case 1:
                return "ピン";
            case 2:
                return "ニゾウ";
            case 3:
                return "サンタ";
            case 4:
                return "ヨツヤ";
            case 5:
                return "ゴケ";
            case 6:
                return "ロッポ";
            case 7:
                return "シチケン";
            case 8:
                return "オイチョ";
            case 9:
                return "カブ";
            default:
                return "エラー";
        }
    }
}