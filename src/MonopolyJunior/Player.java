package MonopolyJunior;

public class Player {
    private String name;
    private Dice dice1;
    private int location = 0;
    private Balance balance;

    Player(String name)
    {
        this.name = name;
        dice1 = new Dice();
        balance = new Balance();
    }

    String getName()
    {
        return name;
    }

    public int getBalance()
    {
        return this.balance.get();
    }

    void roll() {
        dice1.roll();

        dice1.getFaceValue();

        location += dice1.getFaceValue();

    }

    boolean isGameDone() {
        return balance.get() < 0;
    }

    public int getLocation() {
        return location;
    }
}
