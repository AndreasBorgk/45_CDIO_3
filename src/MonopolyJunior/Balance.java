package MonopolyJunior;

public class Balance {
    private int value;

    public Balance()
    {
        reset();
    }

    public void add(int value){
        this.value += value;

    }

    public int get(){
        return value;
    }

    public void reset(){
        value = 20;
    }
}
