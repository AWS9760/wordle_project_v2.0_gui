# Maze Solver Visualizer (JavaFX)

Interactive maze and pathfinding visualizer built with Java and JavaFX.

> This README documents the **Java project only** (inside `src/`).
> The `Python Mazesolver/` folder is intentionally excluded.

## Overview

Maze Solver Visualizer is an educational desktop app for exploring how different pathfinding algorithms behave on a grid. You can draw walls, place start/end nodes, generate mazes, and watch algorithms animate their exploration and final path.

## Features

- 4 pathfinding algorithms:
  - `BFS`
  - `DFS`
  - `A*`
  - `Dijkstra`
- Maze generation:
  - `Random`
  - `Wilson's Algorithm`
- Interactive grid editing:
  - Left click / drag to draw walls
  - Right click to place/move start and end
- Real-time animation with speed control
- Adjustable grid size
- Live status metrics:
  - nodes visited
  - path length
  - path cost
  - execution time
  - run status

## Tech Stack

- Java
- JavaFX (`javafx.controls`, `javafx.graphics`)
- Object-oriented architecture (Model / UI / Controller separation)

## Project Structure

```text
src/
├── Main.java
├── controller/
│   ├── AnimationController.java
│   └── MazeController.java
├── model/
│   ├── Cell.java
│   ├── CellType.java
│   ├── Grid.java
│   ├── algorithms/
│   │   ├── BFS.java
│   │   ├── DFS.java
│   │   ├── AStar.java
│   │   └── Dijkstra.java
│   └── maze/
│       ├── MazeGenerator.java
│       └── WilsonsAlgorithm.java
├── ui/
│   ├── GridRenderer.java
│   ├── Toolbar.java
│   └── StatusBar.java
└── utils/
    └── Pair.java
```

## How to Run

### Option 1: IntelliJ IDEA (recommended)

1. Open the project in IntelliJ.
2. Configure a JDK (17+ recommended).
3. Add JavaFX SDK to project libraries.
4. Set VM options for run configuration:

```bash
--module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.graphics
```

5. Run `Main.java`.

### Option 2: Command Line

From project root:

```bash
javac --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.graphics -d out src/Main.java src/controller/*.java src/model/*.java src/model/algorithms/*.java src/model/maze/*.java src/ui/*.java src/utils/*.java
java --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.graphics -cp out Main
```

> Replace `path/to/javafx-sdk/lib` with your local JavaFX SDK path.

## Usage Guide

1. Choose an algorithm from the dropdown.
2. Build a maze manually (left click/drag) or generate one.
3. (Optional) adjust speed and grid size.
4. Click **Start Visualization**.
5. Watch explored nodes and final path.
6. Use:
   - **Reset Path** to clear only traversal results
   - **Clear Grid** to reset the full board

## Algorithm Notes

- **BFS**: shortest path for unweighted grids.
- **DFS**: depth-first exploration, not guaranteed shortest path.
- **Dijkstra**: weighted shortest-path approach using cumulative distance.
- **A\***: informed search using Manhattan heuristic + path cost.

## Future Improvements

- Side-by-side algorithm comparison view
- Additional maze generators
- Save/load maze configurations
- Export run statistics
- Step-by-step execution mode

## License

