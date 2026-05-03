# 🎯 Wordle v2.0 (GUI Edition)

A modern **Wordle clone with a graphical interface**, built using **JavaFX**.  
This desktop application delivers an interactive gameplay experience with visual feedback, scoring mechanics, and a clean UI design.

---

## ✨ Features

- 🎮 **Classic Wordle Gameplay**  
  Guess the hidden **5-letter word** within **6 attempts**.

- 🎨 **Dynamic Color Feedback**  
  - 🟩 Correct letter in correct position  
  - 🟨 Correct letter in wrong position  
  - ⬜ Letter not in the word  

- 💡 **Hint System**  
  - Up to **2 hints per game**  
  - Reveals a correct letter and its position  

- 🏆 **Scoring System**
  - Points based on remaining attempts  
  - 🎯 **+100 bonus** for winning without hints  
  - 📈 Tracks **session high score**

- 🖥️ **Graphical Interface**
  - Built with **JavaFX + FXML**
  - Styled using custom **CSS**
  - Supports keyboard input (**Enter key**) and buttons

---

## 📸 Screenshots

> Add a screenshot of your game here (recommended for better presentation)

---

## ⚙️ Requirements

| Tool        | Version |
|------------|--------|
| Java (JDK) | 23 |
| JavaFX     | 17+ |
| Maven      | 3+ |

---

## 🚀 How to Run

### ▶️ Using Maven

# Windows
```bash
.\mvnw.cmd clean javafx:run
```

# Linux / macOS
```bash
./mvnw clean javafx:run
```

---

### 💻 Using IDE

1. Open the project as a **Maven project**
2. Run the main class:

---

## 🎯 How to Play

1. Enter a valid **5-letter word**
2. Press **Enter** or click **Guess**
3. Analyze the color feedback
4. Use hints if needed (limited)
5. Guess the word before attempts run out!

---

## 🧮 Scoring System

- Score increases based on **remaining attempts**
- Winning without hints grants a **bonus of 100 points**
- Using hints reduces the final score
- Losing resets the current score
- **High score** is tracked during the session

---

## 📂 Project Structure

```bash
src/
├── main/
│   ├── java/WordleProject/
│   │   ├── Wordle.java
│   │   ├── WordleController.java
│   │   ├── WordleGame.java
│   │   └── GameLogic.java
│   └── resources/WordleProject/
│       ├── WordleView.fxml
│       ├── wordle.css
│       ├── words.txt
│       └── images/
```

---

## 🛠️ Tech Stack

- **Language:** Java  
- **UI Framework:** JavaFX (FXML + CSS)  
- **Build Tool:** Maven  

---

## 💡 Future Improvements

- Add animations and transitions  
- Improve UI responsiveness  
- Add difficulty levels  
- Persistent high score system  
- On-screen keyboard UI  

---

## 🤝 Contributing

Contributions are welcome!  
Feel free to fork the project and submit a pull request.

---

## 📜 License

This project is open-source and available under the **MIT License**.

---

## 👨‍💻 Author

**Abdul Wali**  
