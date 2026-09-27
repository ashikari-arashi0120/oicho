package players;

public class Computer extends HandCards{
    public String name;
    public Computer(int cards1,int cards2,int cards3,String name){
        super(cards1, cards2, cards3);
        this.name = name;
    }

    public String Role(int num1,int num2,int num3){
        if((num1 == num2)&&(num2 == num3)){
           return "アラシ";
       }else{
           return "役無し";
       }
   }
}
