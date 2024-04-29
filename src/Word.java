/**********************************************************************
 * @file Word.java
 * @author LANDON ELLIS, ELLA MASINO, BRADEN ROOS
 * @date: April 15, 2024
 * @acknowledgement: Help from Dr. Pauca in checking for letters in guess word
 ***********************************************************************/

import java.util.Scanner;

// Word class to check guesses against the secret word
class Word {
    private String secretWord;

    // Constructor to set the secret word
    public Word(String word) {
        secretWord = word.toLowerCase();
    }

    /**
     * Takes user's guess and checks it against the secret word after setting it to lowercase
     * @param  guess : String, takes user guess as input for method
     * @return result, which is then printed to the console in the ideal format
     */
    public String checkGuess(String guess) {
        guess = guess.toLowerCase();
        String result = ""; // Start with an empty string for the result

        for (int i = 0; i < secretWord.length(); i++) {
            char secretChar = secretWord.charAt(i);
            char guessChar = guess.charAt(i);

            if (secretChar == guessChar) {
                result += "[" + secretChar + "]"; // Correct letter in correct position
            } else if (secretWord.contains(String.valueOf(guessChar))) {
                result += "{" + guessChar + "}"; // Letter in word but in wrong position
            } else {
                result += "_"; // Letter not in the word
            }
        }

        return result;
    }
}
