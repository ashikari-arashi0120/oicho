package players;

public abstract class HandCards {
    public int cards1;
    public int cards2;
    public int cards3;

    HandCards(int cards1,int cards2,int cards3){
        this.cards1 = cards1;
        this.cards2 = cards2;
        this.cards3 = cards3;
    }
    
    public int result(){
        return (cards1 + cards2 + cards3) % 10;
    }

    abstract public String Role(int num1,int num2,int num3);
}
