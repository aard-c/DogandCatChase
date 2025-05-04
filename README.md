# DogandCatChase

# Dog vs. Cat: Grid Chase Game (Java Swing)

A simple 2D grid-based Java Swing game where you play as a dog being chased by a cat. Collect steaks, and bark to survive and score points.

---

## Gameplay

- Move the **dog** with `W`, `A`, `S`, `D`.
- The **cat** automatically chases the dog, moving every **2 turns**.
- You start with **3 barks** (`SPACE` key) that push the cat away.
- Collect **2 red steaks** (🐾) on the grid to earn **1 point** and **restore your 3 barks**.
- Avoid being caught! If the cat reaches the dog, the game ends.

---

## Features

- Java Swing GUI with grid-based rendering
- Colored cells:
  - 🟦 Dog (You)
  - 🟨 Cat (Enemy)
  - 🟥 Steak (Collectibles)
  - ⬛ Empty tiles
- Simple AI (Cat chases Dog)
- Special ability: Bark to repel the cat
- Steak collection and score tracking
- Balanced difficulty (cat moves slower, bark resets)
- Easily extendable with lives, obstacles, power-ups, etc.

---

## How to Run

1. Make sure you have **Java 8 or higher** installed.
2. Compile the files:

```bash
javac *.java
