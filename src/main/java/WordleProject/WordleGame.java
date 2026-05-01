package WordleProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;

public class WordleGame implements GameLogic {
    private static final ArrayList<String> dictionary = new ArrayList<>();
    private static final int maxTries = 6;
    private static final int wordLength = 5;
    private static final int maxHints = 2;
    private static final int noHintBonus = 100;

    private String targetWord;
    private int tries;
    private int hintsUsed;
    private ArrayList<Integer> revealedPositions;

    static {
        loadWords();
    }

    public WordleGame() {
        resetGame();
    }

    private static void loadWords() {
        try (InputStream in = WordleGame.class.getResourceAsStream("/WordleProject/words.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == wordLength) {
                    dictionary.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load dictionary: " + e.getMessage());
        }
    }

    public void resetGame() {
        Random r = new Random();
        this.targetWord = dictionary.get(r.nextInt(dictionary.size()));
        this.tries = maxTries;
        this.hintsUsed = 0;
        this.revealedPositions = new ArrayList<>();
    }

    public String checkGuess(String guess) {
        StringBuilder result = new StringBuilder("WWWWW");
        char[] targetArr = targetWord.toCharArray();
        char[] guessArr = guess.toCharArray();

        for (int i = 0; i < wordLength; i++) {
            if (guessArr[i] == targetArr[i]) {
                result.setCharAt(i, 'C');
                targetArr[i] = '!';
            }
        }

        for (int i = 0; i < wordLength; i++) {
            if (result.charAt(i) != 'C') {
                for (int j = 0; j < wordLength; j++) {
                    if (guessArr[i] == targetArr[j]) {
                        result.setCharAt(i, 'I');
                        targetArr[j] = '!';
                        break;
                    }
                }
            }
        }

        return result.toString();
    }

    public void decrementTries() {
        this.tries--;
    }

    public int getTries() {
        return this.tries;
    }

    public String getHint() {
        if (hintsUsed >= maxHints) {
            return "No hints remaining!";
        }

        hintsUsed++;

        Random rand = new Random();
        int position;
        do {
            position = rand.nextInt(wordLength);
        } while (revealedPositions.contains(position));

        revealedPositions.add(position);
        return String.format("Letter at position %d is %c", position + 1, targetWord.charAt(position));
    }

    public int getRemainingHints() {
        return maxHints - hintsUsed;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public int getMaxHints() {
        return maxHints;
    }

    public int getNoHintBonus(){
        return noHintBonus;
    }

    public int getWordLength() {
        return wordLength;
    }

    public boolean isGameOver() {
        return tries == 0 ;
    }
}
