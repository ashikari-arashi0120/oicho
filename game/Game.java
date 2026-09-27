package game;

import java.util.Scanner;

import players.Computer;
import players.Player;

public class Game {
    //ゲーム起動のメソッド
    public void play(Scanner scan){
        System.out.println("--------------------おいちょかぶスタート！--------------------");
        System.out.println("");
        Boolean play = true;
        int i = 0;
        do{
            Player p = new Player(Choice.random(),Choice.random());
            Computer[] computers = new Computer[3];
            computers[0] = new Computer(Choice.random(),Choice.random(),Choice.random(),"COM1");
            computers[1] = new Computer(Choice.random(),Choice.random(),Choice.random(),"COM2");
            computers[2] = new Computer(Choice.random(),Choice.random(),Choice.random(),"COM3");

            if(i == 3){
                i = 0;
                play = playerParent(p,computers,scan);
            }else{
                play = comParent(computers[i], computers, p, scan);
                i++;
            }
        }while(play);
        System.out.println("--------------------おいちょかぶ終了！--------------------");
    }

    //プレイヤーが親の時のメソッド
    public Boolean playerParent(Player p,Computer[] computers,Scanner scan){
        System.out.println("プレイヤーが親です");
        String player = "親";
        Choice.playerChoice(p, scan);

        String playerRole = p.Role(p.cards1, p.cards2, p.cards3);
        String[] comRole = new String[3];
        comRole[0] = computers[0].Role(computers[0].cards1, computers[0].cards2, computers[0].cards3);
        comRole[1] = computers[1].Role(computers[1].cards1, computers[1].cards2, computers[1].cards3);
        comRole[2] = computers[2].Role(computers[2].cards1, computers[2].cards2, computers[2].cards3);

        if(playerRole.equals("アラシ")){
            return Battle.playerParentArashi(comRole, computers, p, player, scan);
        }else{
            return Battle.playerParentNonArashi(playerRole,comRole, computers, p, scan);
        }
    }

    //コンピュータが親の時のメソッド
    public Boolean comParent(Computer c,Computer[] computers,Player p,Scanner scan){
        System.out.println(c.name + "が親です");
        String player = "子";
        Choice.playerChoice(p, scan);

        String comRole = c.Role(c.cards1, c.cards2, c.cards3);
        String playerRole = p.Role(p.cards1, p.cards2, p.cards3);
        
        if(playerRole.equals("アラシ")){
            return Battle.playerChildArashi(comRole, c, p, player, scan);
        }else{
            return Battle.playerChildNonArashi(comRole, c, p, scan);
        }
    }
}
