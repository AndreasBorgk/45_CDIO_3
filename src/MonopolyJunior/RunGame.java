package MonopolyJunior;

import java.util.Scanner;
import java.util.Vector;

    class Main {

        private static Vector<Player> players;
        private static Board b = new Board();
        static Scanner sc = new Scanner(System.in);



        private static void updateBalance(Player currentPlayer) // function to update the current
        // Players balance given the vectors field value.
        {
            Field f = b.getField(currentPlayer.getLocation());
            //currentPlayer.updateBalance(f.value);
        }

        private static String fieldName(Player currentPlayer) // prints out the given locations
        // fieldname for the current player
        {
            Field f = b.getField(currentPlayer.getLocation());
            return f.name;
        }

        private static int fieldValue(Player currentPlayer)
        // prints out the fieldValue for the current location.
        {
            Field f = b.getField(currentPlayer.getLocation());
            return f.value;
        }

        private static String playerName() {
            System.out.println("what is your name? ");
            
            Scanner name = new Scanner(System.in);

            String nameVal = name.nextLine();

            return nameVal;
        }
        private static int playerAge() {
            Scanner age = new Scanner(System.in);
            int ageVal = age.nextInt();
            return ageVal;
        }

        private static void inputPlayerNames() {
            System.out.println("rules for DiceGame: \n"
                    + "1. You start with 1000 points, when you hit 3000 points, you will win the game\n"
                    + "2. If you land on the Werewall, you'll get an extra turn \n");

            int amountPlayer;

            System.out.println("How many players are playing?");
            Scanner amount = new Scanner(System.in);

            while (true) {
                amountPlayer = amount.nextInt();

                if (amountPlayer < 2) {
                    System.out.println("You are not enough players.");
                } else if (amountPlayer > 4) {
                    System.out.println("You are too many players");
                } else {
                    System.out.println(amountPlayer + " players are playing.");
                    break;
                }
            }

            for (int i = 0; i < amountPlayer; i++) {
                System.out.println("What is your name?");
                playerName();
                System.out.print(playerName());


                System.out.println(", how old are you?");
                playerAge();
                System.out.println(playerName() + " is " + playerAge() + " years old.");
                players.add(new Player(startvalue, playerName(), playerAge()));
            }

            if (amountPlayer == 2) {
               Balance.startvalue(startvalue = 20);
                System.out.println("each player starts with: " + startvalue);
            } else if (amountPlayer == 3) {
                int startvalue = 18;
                System.out.println("each player starts with: " + startvalue);
            } else {
                int startvalue = 16;
                System.out.println("each player starts with: " + startvalue);
            }
        }




        private static void doTurn(){ // used from CDIO1, with changes.
            do {
                System.out.println(currentPlayer.getName() + " press 'K' if you're ready to throw");
                sc.next(); // asks if theyre ready to throw, by pressing K they Throw.

                currentPlayer.roll(); // player rolls the dices.
                updateBalance(currentPlayer); // the balance for the player updates
                fieldName(currentPlayer); // fieldName gets saved.
                System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue());

                System.out.println("you landed on field: " + currentPlayer.getLocation() + ", " + (fieldName(currentPlayer)) +
                        ", with the value of: " + fieldValue(currentPlayer));
                System.out.println("your balance is: " + currentPlayer.getBalance());


            } while (!currentPlayer.isGameDone()); //the loop goes on if someone gets an extra
            // or the players have hit the estimated value to finish the game.
        }

        private static void playGame() { // used from cdio 1, with changes.
            int round = 1; // sets start round to 1.

            while ((!p1.isGameDone()) && !(p2.isGameDone())) {
                System.out.println("Round: " + round);
                round++; // whenever a new turn starts, the round gets ++.

                currentPlayer = p1;
                doTurn(); // sets current player to p1, and make him do the turn.

                currentPlayer = p2;
                doTurn(); // sets current player to p2, and makes him do his turn.

                System.out.println("current score is: " + p1.getName() + ": " + p1.getBalance() + " and " + p2.getName()
                        + ": " + p2.getBalance()); // prints out the current score.
            }
            if (p1.isGameDone()) { // checks if p1 has won, and if the player has, prints out name and balance.
                System.out.println(p1.getName() + " won with: " + p1.getBalance());

                p1.incGamesWon();
                System.out.println("Games won : " + p1.getGamesWon());
            }

            if (p2.isGameDone()) { // checks if p2 has won, and if the player has, prints out name and balance.
                System.out.println(p2.getName() + " won with: " + p2.getBalance());

                p2.incGamesWon();
                System.out.println(p2.getName() + " games won : " + p2.getGamesWon());
            }
        }

        private static void newGame() { // Used from cdio1, but with changes.
            inputPlayerNames();
            String another = "y";

            while (another.equalsIgnoreCase("y")) { // asks if they want to play again
                // if yes, newgame Method will be called.
                playGame();
                System.out.println();
                System.out.println("would you like to play again? (y/n)");
                another = sc.next();

                p1.newGame();
                p2.newGame();
            }

        }


        public static void main(String[] args) {
            newGame();
        }

        public static void setPlayers(Vector<Player> players) {
            Main.players = players;
        }
    }

