import java.util.Scanner;

// Word class to check guesses against the secret word
class Word {
    // need to add comments
    private String secretWord;

    // Constructor to set the secret word
    public Word(String word) {
        secretWord = word.toLowerCase();
    }

    // Method to check the guess against the secret word
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
