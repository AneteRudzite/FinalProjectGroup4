
package Hangman;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
<<<<<<< HEAD

=======
>>>>>>> dd6e36366df036bdb875e6e9aa765d54a8caef72

public class Hangman {

    private static String[] capitalCities = {"RIGA", "ATHENS", "OSLO",  "PARIS", "BERLIN", "MADRID", "LONDON", "TIRANA",
            "VIENNA", "MINSK", "BRUSSELS", "SARAJEVO", "SOFIA", "ZAGREB", "PRAGUE", "COPENHAGEN", "TALLINN", "HELSINKI",
            "BUDAPEST", "REYKJAVIK", "DUBLIN", "ROME", "PRISTINA", "VADUZ", "VILNIUS", "LUXEMBOURG", "SKOPJE", "VALLETTA",
            "CHISINAU", "MONACO", "PODGORICA", "AMSTERDAM", "WARSAW", "LISBON", "BUCHAREST", "MOSCOW", "BELGRADE", "BRATISLAVA",
            "LJUBLJANA", "STOCKHOLM", "BERN", "ANKARA"};
<<<<<<< HEAD

=======
>>>>>>> dd6e36366df036bdb875e6e9aa765d54a8caef72

    private static String capitalCity = capitalCities[(int) (Math.random() * capitalCities.length)];
    private static String asterisk = new String(new char[capitalCity.length()]).replace("\0", "*");


    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char play = 'y';


        System.out.println("Hello! You have to guess any capital city of Europe.");
        System.out.println(" Please write your name");
        String player = sc.next();

        while (play == 'y') {

        while(play == 'y') {

            capitalCity = capitalCities[(int) (Math.random() * capitalCities.length)];
            DatabaseValues.main(new String[] {player, capitalCity});
            asterisk = new String(new char[capitalCity.length()]).replace("\0", "*");
            while (count < 7 && asterisk.contains("*")) {
                System.out.println("Guess any letter in the word");

                System.out.println(asterisk);
                String guess = sc.next();
                guess = guess.toUpperCase();

                Pattern pattern = Pattern.compile("[A-Z]");
                Matcher matcher = pattern.matcher(guess);

                if (matcher.matches()) {
                    System.out.println("Right");
                } else {
                    System.out.println("Wrong");
                }




                hang(guess);
            }

            System.out.println("Do you want to play again. y/n");
            play = sc.next().charAt(0);

            if (play == 'y') {
                System.out.println(" Please write your name");
                player = sc.next();
                count = 0;
            }
        }
        sc.close();
    }

}

    public static void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < capitalCity.length(); i++) {
            if (capitalCity.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += capitalCity.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
            hangmanImage();
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(capitalCity)) {
            System.out.println("Correct! You win! The word was " + capitalCity);
        }
    }

    public static void hangmanImage() {
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + capitalCity);
        }
    }


}





