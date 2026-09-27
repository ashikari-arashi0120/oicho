package players;

public class Player extends HandCards{
    public Player(int cards1,int cards2){
        super(cards1, cards2, 0);
    }

    public String Role(int num1,int num2,int num3){
        if((num1 == num2)&&(num2 == num3)){
            return "アラシ";
        }else if((num1 == 9)&&(num2 == 1)&&(num3 == 0)){
            return "クッピン";
        }else if((num1 == 4)&&(num2 == 1)&&(num3 == 0)){
            return "シッピン";
        }else{
            return "役無し";
        }
    }
}
