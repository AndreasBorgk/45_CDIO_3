package MonopolyJunior;

import com.sun.java.accessibility.util.GUIInitializedListener;

import java.util.Scanner;
import java.util.Vector;

    class Main {

        private static Vector<Player> players;
        static GUI gui = new GUI(b.getFields());
        static Scanner sc = new Scanner(System.in);



        private static void updateBalance(Player currentPlayer) // function to update the current
        // Players balance given the vectors field value.
        {
            GUI_Street f = (GUI_Street) b.getField(currentPlayer.getLocation());
            int rent = Integer.parseInt(f.getRent());
            currentPlayer.updateBalance(rent);
        }

        private static String fieldName(Player currentPlayer) // prints out the given locations
        // fieldname for the current player
        {
            return b.getField(currentPlayer.getLocation()).getTitle();
        }

        private static int fieldValue(Player currentPlayer)
        // prints out the fieldValue for the current location.
        {
            GUI_Street f = (GUI_Street) b.getField(currentPlayer.getLocation());
            int rent = Integer.parseInt(f.getRent());
            return rent;
        }

        private static String playerName() {
            System.out.println("what is your name? ");
            
            Scanner name = new Scanner(System.in);

            String nameVal = name.nextLine();

            return nameVal;
        }
        private static int playerAge() {
            System.out.println("How old are you? ");

            Scanner age = new Scanner(System.in);

            int ageVal = age.nextInt();

            return ageVal;
        }


        private static int getPlayerCount() {
            System.out.println("How many players are playing? ");

            Scanner amountScanner = new Scanner(System.in);

            int playerCount = 0;

            while (true) {
                playerCount = amountScanner.nextInt();

                if(playerCount < 2) {
                    System.out.println("You are not enough players.");
                }  else if (playerCount > 4) {
                    System.out.println("you are too many players");
                }  else {
                    System.out.println(playerCount + " players are playing.");
                    return playerCount;
                }
            }
        }

        private static int calcStartAmount(int playerCount) {
            int startAmount = 0;

            switch(playerCount){
                case 2:
                    startAmount = 20;
                    break;

                case 3:
                    startAmount = 18;
                    break;
                default:
                    startAmount = 16;
                    break;
            }
            System.out.println("each player start with: " + startAmount);
            return startAmount;
        }


        private static void setupGame(){
            System.out.println("rule for our Monopoly Junior game: \n");
            int playerCount = getPlayerCount();
            int startAmount = calcStartAmount(playerCount);

            for (int i = 0; i < playerCount; i++) {

                Player player = new Player(playerName(), playerAge(), new Balance(startAmount));

                System.out.println(player.getName() + " is " + player.getAge() + " years old. ");

                 players.add(player);
            }
        }

        private void handleSpecielEvent(Player currentPlayer) {
            if(currentPlayer.isInJail()){
                currentPlayer.payFine(100);
                //Value need to be present somewhere.. not as shown here.
            }
        }
        private void handleField(Player currentPlayer) {
            IField f = b.getField(currentPlayer.getLocation());
            
            f.handlePlayer(currentPlayer);
        }

        private void printOutFieldInfo(Player currentPlayer){
            System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue());

            System.out.println("You landed on field:  " + currentPlayer.getLocation() + ", " + fieldName(currentPlayer));
        }

        private void doTurn(Player currentPlayer) {
            //used from CDIO1, with changes.
           do {
               System.out.println(currentPlayer.getName() + " press 'K' if you are ready to throw");
               sc.next(); // ask if theyre ready to throw, by pressing K they throw.

               handleSpecielEvent(currentPlayer);  // In jail or stuff like that
               currentPlayer.roll(); // player rolls the dice
               printOutFieldInfo(currentPlayer);
               handleField(currentPlayer);

               /*
               updateBalance(currentPlayer); // the balance for the player updates
               fieldName(currentPlayer); // fieldName gets saved.
               System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue());
               System.out.println("you landed on field: " + currentPlayer.getLocation() + ", " +
               (fieldName(currentPlayer)) + ", with the value of: " fieldValue(currentPlayer));
               System.out.println("your balance is: " + currentPlayer.getBalance());
                */

            } while (!currentPlayer.isGameDone()); // the loop continues until a player hit the estimated value
        }


        

        private static void playGame() { // used from cdio 1, with changes.
            int round = 1; // sets start round to 1.

            /*
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

             */
        }

        private static void newGame() { // Used from cdio1, but with changes.
            setupGame();
            String another = "y";

            while (another.equalsIgnoreCase("y")) { // asks if they want to play again
                // if yes, newgame Method will be called.
                playGame();
                System.out.println();
                System.out.println("would you like to play again? (y/n)");
                another = sc.next();

                players.clear();

            }

        }


        public static void main(String[] args) {
            newGame();
        }

        public static void setPlayers(Vector<Player> players) {
            Main.players = players;
        }
    }

