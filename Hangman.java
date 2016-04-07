/**
 * Author: Luke Heary
 * Date Created: 4/6/16
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    Scanner in;
    String[] letters;
    String current;
    ArrayList wrongLetters;
    String[] correctLetters;
    int numberOfGuesses;
    int numberOfGuessesLeft;

    public Hangman () {
        System.out.println("Welcome to Hangman!\nPlayer one, please type your word.");
        this.in = new Scanner(System.in);
        String word = in.nextLine();

        while (!allLetters(word)) {
            System.out.println("Your word contains a symbol/number, try again.");
            word = in.nextLine();
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }

        System.out.println("\nPlayer two, guess your first letter!");
        this.current = in.nextLine();
        this.letters = (word.split(""));
        this.correctLetters = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            correctLetters[i] = "___";
        }

        this.wrongLetters = new ArrayList();
        this.numberOfGuesses = 0;

        if (this.current.length() > 1) {
            System.out.println("Letter has to be one character long.");
        }
        else if (isValid(this.current)) {
            for (int i = 0; i < this.letters.length; i++) {
                if (letters[i].equals(this.current)) {
                    correctLetters[i] = this.current;
                }
            }
            drawMan(numberOfGuesses);
            System.out.println("\nYou have guessed a correct letter!");
            numberOfGuessesLeft = 6 - numberOfGuesses;
            System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
            System.out.println("Correct Letters: " + Arrays.asList(correctLetters));
            System.out.println("Wrong Letters: " + wrongLetters.toString() );
        }
        else {
            numberOfGuesses++;
            if (allLetters(this.current)) {
                wrongLetters.add(this.current);
            }
            System.out.println("\nThe word does not contain that letter!");
            numberOfGuessesLeft = 6 - numberOfGuesses;
            System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
            System.out.println("Correct Letters: " + Arrays.asList(correctLetters));
            System.out.println("Wrong Letters: " + wrongLetters.toString() );
            drawMan(numberOfGuesses);
        }


        while (numberOfGuesses < 6) {
            System.out.println("Player two, enter your next letter!");
            this.current = this.in.nextLine();
            if (this.current.length() > 1) {
                System.out.println("Letter has to be one character long.");
            }
            else if (isValid(this.current)) {
                if (!Arrays.asList(correctLetters).contains((this.current))) {
                    drawMan(numberOfGuesses);
                    for (int i = 0; i < this.letters.length; i++) {
                        if (letters[i].equals(this.current)) {
                            correctLetters[i] = this.current;
                        }
                    }
                    System.out.println("\nYou have guessed a correct letter!");
                    numberOfGuessesLeft = 6 - numberOfGuesses;
                    System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
                    System.out.println("Correct Letters: " + Arrays.asList(correctLetters));
                    System.out.println("Wrong Letters: " + wrongLetters.toString() );
                }
                else {
                    drawMan(numberOfGuesses);
                    System.out.println("You have already guessed that!");
                    System.out.println("Correct Letters: " + Arrays.asList(correctLetters));
                    System.out.println("Wrong Letters: " + wrongLetters.toString() );
                }
            }
            else {
                if (!wrongLetters.contains(this.current)) {
                    numberOfGuesses++;
                    if (allLetters(this.current)) {
                        wrongLetters.add(this.current);
                    }
                    System.out.println("\nThe word does not contain that letter!");
                    numberOfGuessesLeft = 6 - numberOfGuesses;
                    System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
                    System.out.println("Correct Letters: " + Arrays.asList(correctLetters));
                    System.out.println("Wrong Letters: " + wrongLetters.toString() );
                    drawMan(numberOfGuesses);
                }
                else {
                    drawMan(numberOfGuesses);
                    System.out.println("\nYou have already guessed that!");
                    numberOfGuessesLeft = 6 - numberOfGuesses;
                    System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
                    System.out.println("Correct Letters: " + Arrays.asList(correctLetters));
                    System.out.println("Wrong Letters: " + wrongLetters.toString() );
                }
            }

            if (!Arrays.asList(correctLetters).contains("___")) {
                System.out.println("Congrats! The word was '" + word + "'!");
                break;
            }

        }

        if (numberOfGuesses == 6) {
            System.out.println("\nYou have guessed 5 incorrect times!");
            System.out.println("The word was '" + word +"'!");
            System.out.println("Game over!");
        }
    }

    public boolean isValid(String letter) {
        for (int count = 0; count < this.letters.length; count++) {
            if (this.letters[count].equals(letter)) {
                return true;
            }
        }
        while (!allLetters(letter)) {
            System.out.println("Your letter is either a number or a symbol, try again");
            letter = in.nextLine();
        }

        return false;
    }


    public void drawMan(int numberOfGuesses) {
        switch (numberOfGuesses) {
            case 0 :
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    ");
                System.out.println("    |    ");
                System.out.println("    |    ");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;

            case 1:
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    o");
                System.out.println("    |    ");
                System.out.println("    |    ");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;

            case 2:
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    o");
                System.out.println("    |    |");
                System.out.println("    |    ");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;

            case 3:
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    o");
                System.out.println("    |    |");
                System.out.println("    |     \\");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;

            case 4:
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    o");
                System.out.println("    |    |");
                System.out.println("    |   / \\");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;

            case 5:
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    o");
                System.out.println("    |    |/");
                System.out.println("    |   / \\");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;

            case 6:
                System.out.println("     ____ ");
                System.out.println("    |    |");
                System.out.println("    |    o");
                System.out.println("    |   \\|/");
                System.out.println("    |   / \\");
                System.out.println("    |    ");
                System.out.println(" -----------");
                break;
            }
        }


    public boolean allLetters(String word) {
        return word.matches("[a-zA-Z]+");
    }

    public static void main (String[] args) {
        Hangman game = new Hangman();
    }
}