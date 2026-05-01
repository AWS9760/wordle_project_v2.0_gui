package WordleProject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class WordleController {

    private GameLogic game;
    private int baseScore = 0;
    private int highScore = 0;

    @FXML private Text scoreText;
    @FXML private Text highScoreText;
    @FXML private Text triesText;
    @FXML private TextField guessField;
    @FXML private Button guessButton;
    @FXML private GridPane grid;
    @FXML private Button hintButton;
    @FXML private Text hintsText;

    public void initialize() {
        startNewGame();
        guessField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                onGuess();
            }
        });
    }

    private void startNewGame() {
        game = new WordleGame();
        updateUI();
        setupGrid();
        guessField.clear();
        grid.getChildren().clear();
    }

    @FXML
    public void onHint() {
        String hint = game.getHint();
        showMessage("Hint", hint);
        updateUI();

        if (game.getRemainingHints() <= 0) {
            hintButton.setDisable(true);
        }
    }

    public void onGuess() {
        String guess = guessField.getText().toUpperCase().trim();
        guessField.clear();

        if (guess.length() != game.getWordLength() || !guess.matches("[A-Z]+")) {
            errorMessage("Invalid Input", "Please enter a valid 5-letter word.");
            return;
        }

        String result = game.checkGuess(guess);
        displayResult(guess, result);
        game.decrementTries();

        if (result.equals("CCCCC") || game.isGameOver()) {
            endGame(result.equals("CCCCC"));
        } else {
            updateUI();
        }
    }

    private void endGame(boolean won) {

        String message;

        if(won){
            message = String.format("You Win! Score: %d", winScore());
            showMessage("Congratulations" , message);
        }
        else{
            message = String.format("Game Over! The word was %s. Score: %d", game.getTargetWord(), getScore());
            errorMessage("Game Ended" , message);
            loseScore();
        }

        startNewGame();
    }

    private void setupGrid() {

        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();


        for (int i = 0; i < game.getWordLength(); i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            col.setMinWidth(50);
            col.setPrefWidth(50);
            grid.getColumnConstraints().add(col);
        }


        for (int i = 0; i < game.getMaxTries(); i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(50);
            row.setPrefHeight(50);
            grid.getRowConstraints().add(row);
        }


        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));
    }

    private void updateUI() {
        scoreText.setText(String.format("Score: %d", getScore()));
        highScoreText.setText(String.format("High Score: %d", getHighScore()));
        triesText.setText(String.format("Tries: %d/%d", game.getTries(), game.getMaxTries()));
        hintsText.setText(String.format("Hints: %d/2", game.getRemainingHints()));
        hintButton.setDisable(game.getRemainingHints() <= 0);
    }

    private void displayResult(String guess, String result) {
        for (int i = 0; i < game.getWordLength(); i++) {
            StackPane tile = new StackPane();
            tile.getStyleClass().add("tile");

            Text text = new Text(String.valueOf(guess.charAt(i)));

            switch (result.charAt(i)) {
                case 'C':
                    tile.getStyleClass().add("tile-correct");
                    break;
                case 'I':
                    tile.getStyleClass().add("tile-present");
                    break;
                case 'W':
                    tile.getStyleClass().add("tile-absent");
                    break;
                default:
                    tile.getStyleClass().add("tile-empty");
            }

            tile.getChildren().add(text);
            grid.add(tile, i, (game.getMaxTries()-game.getTries()));
        }
    }

    private void errorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Image image = new Image(getClass().getResourceAsStream("/WordleProject/WordleLogo2.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        alert.setGraphic(imageView);
        alert.showAndWait();
    }

    public int winScore(){
        if(game.getRemainingHints() == game.getMaxHints()){
            if(game.getTries() == 0)
                baseScore += (50 + game.getNoHintBonus());
            else
                baseScore += ((game.getTries()*50) + game.getNoHintBonus());
        }
        else{
            if(game.getTries() == 0)
                baseScore += 50;
            else
                baseScore += (game.getTries()*50);
        }

        return baseScore;
    }

    public int getScore() {
        return baseScore;
    }

    public int getHighScore(){
        if(highScore < baseScore){
            highScore = baseScore;
        }

        return highScore;
    }

    public void loseScore(){
        baseScore = 0;
    }
}
