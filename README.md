# Sorting Algorithm Visualizer

A Java-based GUI application that visualizes Selection Sort and Insertion Sort algorithms with interactive features for educational purposes.

## 📋 Project Information

**Course:** Data Structures  
**Lecturer:** Drs. Nurul Hidayat, M.Kom. (19630404 198903 1 002)

### Team Members

- Rajni Yafi' Amelia Rahmah (5002221009)
- Hafidz Mulia (5002221022)
- Aghnia Tias Salsabila (5002221107)

## 🎯 Project Overview

This project demonstrates the implementation and visualization of two fundamental sorting algorithms:

- **Selection Sort**: Finds the minimum element and places it at the beginning
- **Insertion Sort**: Builds the sorted array one item at a time

The application provides an interactive GUI to help students understand how these sorting algorithms work step-by-step through visual representation.

## ✨ Features

### Core Functionalities

- **Manual Input**: Enter custom array values (comma-separated format)
- **Random Generation**: Generate random arrays with customizable size (1-100 elements)
- **Algorithm Selection**: Choose between Selection Sort and Insertion Sort
- **Visual Animation**: Real-time bar chart visualization with color coding
- **Reset Function**: Restore to default array for repeated demonstrations

### Visual Indicators

- 🔵 **Blue Bars**: Unsorted elements
- 🔴 **Red Bars**: Currently comparing elements
- 🟢 **Green Bars**: Sorted elements

## 🚀 How to Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt

### Compilation and Execution

1. **Navigate to project directory:**

   ```bash
   cd /path/to/SortWithVisual
   ```

2. **Compile the Java files:**

   ```bash
   javac SortingVisualizerGUI.java SortingPanel.java
   ```

3. **Run the application:**
   ```bash
   java SortingVisualizerGUI
   ```

**Quick Command (Mac/Linux):**

```bash
javac SortingVisualizerGUI.java SortingPanel.java && java SortingVisualizerGUI
```

## 📖 User Guide

### 1. Input Methods

#### Manual Input

1. Type numbers in the "Manual Input" field (e.g., `5,3,8,1,9`)
2. Click "Set Array" button
3. The visualization will update with your custom array

#### Random Generation

1. Enter desired array size in "Array Size" field (1-100)
2. Click "Random" button
3. A random array will be generated automatically

### 2. Sorting Process

1. **Select Algorithm**: Choose "Selection Sort" or "Insertion Sort" from dropdown
2. **Start Sorting**: Click "Start Sorting" button
3. **Watch Animation**: Observe the step-by-step sorting process
4. **Completion**: Status will show "Sorting completed!" when done

### 3. Reset

Click "Reset" button to restore the default array: `[5, 3, 8, 1, 9, 4, 7, 2, 6]`

## 🔍 Algorithm Details

### Selection Sort

- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Process**: Repeatedly finds minimum element and swaps with current position

### Insertion Sort

- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Process**: Builds sorted array by inserting elements at correct position

## 📁 Project Structure

```
SortWithVisual/
│
├── SortingVisualizerGUI.java    # Main GUI and sorting logic
├── SortingPanel.java             # Custom panel for visualization
└── README.md                     # Project documentation
```

## 🛠️ Technical Implementation

### Technologies Used

- **Java Swing**: GUI framework
- **Java AWT**: Graphics and event handling
- **Multithreading**: Smooth animation without freezing UI

### Key Components

- **SortingVisualizerGUI**: Main application window with controls
- **SortingPanel**: Custom JPanel for rendering bar chart visualization

## 📝 Notes

- Animation speed is set to 500ms per step for clear visualization
- Maximum array size is limited to 100 elements for optimal display
- Array values are generated between 1-100 for random generation
- The application uses threading to prevent UI freezing during sorting

## 🎓 Learning Objectives

This project helps students:

1. Understand sorting algorithm mechanics
2. Compare algorithm efficiency visually
3. Practice Java GUI programming
4. Implement data structure concepts
5. Apply object-oriented programming principles

## 📧 Contact

For questions or suggestions, please contact team members through university channels.

---

**Date Created:** December 2025  
**Version:** 1.0
