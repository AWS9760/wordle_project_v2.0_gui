package WordleProject;

public interface GameLogic {
    void resetGame();
    String checkGuess(String guess);
    void decrementTries();
    int getTries();
    int getRemainingHints();
    String getHint();
    String getTargetWord();
    boolean isGameOver();
    int getWordLength();
    int getMaxTries();
    int getMaxHints();
    int getNoHintBonus();
}
