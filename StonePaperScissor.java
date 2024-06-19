package stp;
import java.util.ArrayList; //To create and manipulate arraylists
import java.util.Collections; //To import methods to handle collections in Java
import java.util.List; //To work with lists
import java.util.Random; //Provides methods to generate pseudo-random numbers
import java.util.Scanner; //To read input from various sources
import java.util.concurrent.TimeUnit; //To include time enumeration

public class StonePaperScissor {

    static void secondsDelay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void millisecondsDelay(int milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String algo(int usr, int comp){
        //Algorithm of game
        String winner = "";
        if (usr == comp){
            //Tie
            System.out.println("\nTie!");
            winner = ("tie");
        }
        else if(usr>comp){
            //User wins
            if (comp == 1 && usr == 3){
                //Exception to winning of user
                System.out.println("\nYou lost to ThE cOmPuTeR!");
                winner = ("computer");
            }
            else{
                System.out.println("\nYou won this round!");
                winner = ("user");
            }
        }
        else if(comp>usr){
            //Computer wins
            if(usr == 1 && comp == 3){
                //Exception to winning of computer
                System.out.println("\nYou won this round!");
                winner = ("user");
            }
            else{
                System.out.println("\nYou lost to ThE cOmPuTeR!");
                winner = ("computer");
            }
        }
        return winner;
    }



    public static void main(String[] args) {

        //Greetings & Instructions to user
        System.out.println("Hello User! Ready for a game?");
        secondsDelay(2);
        System.out.println("You can use the following to choose -\n1 - Rock\n2 - Paper\n3 - Scissors");
        secondsDelay(2);
        System.out.println("The game will have 3 rounds. One with most wins will conquer the match !\nBeware of your opponent - ThE COmPuTeR !😎");
        secondsDelay(2);

        //Object Creation
        Scanner obj = new Scanner(System.in);
        Random randint = new Random();
        List<String> score = new ArrayList<>(); //Score Updater Array List

        boolean play_Again = true;
        while(play_Again){
            int i =1;
            while(i<=3){
                //User choice input
                System.out.print("\n\nChoose wisely: ");
                int usr = obj.nextInt();

                //Icons
                String rock =
                        "    _______\n" +
                                "---'   ____)\n" +
                                "      (_____)\n" +
                                "      (_____)\n" +
                                "      (____)\n" +
                                "---.__(___)\n";

                String paper =
                        "    _______\n" +
                                "---'   ____)____\n" +
                                "          ______)\n" +
                                "          _______)\n" +
                                "         _______)\n" +
                                "---.__________)";

                String scissor =
                        "    _______\n" +
                                "---'   ____)____\n" +
                                "          ______)\n" +
                                "       __________)\n" +
                                "      (____)\n" +
                                "---.__(___)";

                //Invalid choice exception
                if(usr>3 || usr<1){
                    System.out.println("Please enter a valid choice.");
                }
                else{
                    System.out.println("Stone ...");
                    millisecondsDelay(600);
                    System.out.println("Paper ...");
                    millisecondsDelay(600);
                    System.out.println("Scissors !\n\n");
                    millisecondsDelay(600);

                    int comp = randint.nextInt(3)+1; //Computer choice

                    //Printing user's choice
                    secondsDelay(1);
                    switch (usr){
                        case 1:
                            System.out.println(rock);
                            break;

                        case 2:
                            System.out.println(paper);
                            break;

                        case 3:
                            System.out.println(scissor);
                            break;
                    }

                    secondsDelay(1);
                    //Printing computer's choice
                    switch (comp){
                        case 1:
                            System.out.println("\n" + rock);
                            break;

                        case 2:
                            System.out.println("\n" + paper);
                            break;

                        case 3:
                            System.out.println("\n" + scissor);
                            break;
                    }

                    secondsDelay(1);
                    String result = algo(usr, comp);
                    score.add(result);

                    //Updating score list
                    i++;
                }

            }

            //Printing the score list
            System.out.println("\n\nAnd the score is - ");
            System.out.println("1st round : " + score.get(0) + "\n2nd round : " + score.get(1) + "\n3rd round : " + score.get(2));

            //Calculating the algo
            int tie = Collections.frequency(score,"tie");
            int user_wins = Collections.frequency(score,"user");
            int computer_wins = Collections.frequency(score,"computer");

            //Printing the score
            if(user_wins>computer_wins){
                System.out.println("\n\nCongratulations! You won the match!");
            }
            else if(computer_wins>user_wins){
                System.out.println("\n\nThE cOmPuTeR won the match!");
            }
            else{
                System.out.println("\n\nIt's a tie!");
            }

            System.out.println("Wannna play again ?");
            String choice = obj.next();
            if (choice.equals("No") || choice.equals("no")){
                play_Again = false;
            }

        }

        System.out.println("Bye!");

    }
}
