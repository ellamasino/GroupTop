import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class to run the game
public class Main {
    // need to add comments
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Player 1 inputs the secret word
        System.out.println("Player 1, enter a five-letter word:");
        String secretWord = scanner.next();

        // Ensure the word is exactly five letters
        while (secretWord.length() != 5) {
            System.out.println("Invalid word length. Please enter a five-letter word.");
            secretWord = scanner.next();
        }

        Word word = new Word(secretWord);
        List<String> previousGuesses = new ArrayList<>(); // Store previous guesses and results
        String guess;
        boolean guessedCorrectly = false;
        int guessCount = 0;
        int maxGuesses = 5;

        // Loop until Player 2 guesses the word correctly or runs out of guesses
        while (!guessedCorrectly && guessCount < maxGuesses) {
            // Display previous guesses before the new guess
            if (!previousGuesses.isEmpty()) {
                System.out.println("Previous guesses:");
                for (String pastGuess : previousGuesses) {
                    System.out.println(pastGuess);
                }
            }

            // Player 2 makes a guess
            System.out.println("Player 2, try to guess the word (" + (maxGuesses - guessCount) + " guesses remaining):");
            guess = scanner.next();

            // Check if the guess is five letters
            if (guess.length() != 5) {
                System.out.println("Invalid guess length. Please enter a five-letter guess.");
                continue; // Skip to the next iteration of the loop
            }

            // Increment guess count
            guessCount++;

            // Check the guess against the secret word
            String result = word.checkGuess(guess);
            previousGuesses.add(guess + " -> " + result); // Add the current guess and result to history

            // Print the result
            System.out.println("Result: " + result);

            // Check if the guess is correct
            if (guess.equalsIgnoreCase(secretWord)) {
                guessedCorrectly = true;
                System.out.println("Correct! The word was: " + secretWord);
            } else {
                System.out.println("Try again.");
            }
        }

        // Check if out of guesses
        if (!guessedCorrectly) {
            System.out.println("Out of guesses! The correct word was: " + secretWord);
        }

        scanner.close(); // Close the scanner resource
    }
}
