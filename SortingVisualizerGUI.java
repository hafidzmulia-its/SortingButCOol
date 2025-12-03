import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// How to Run File 
// javac SortingVisualizerGUI.java SortingPanel.java && java SortingVisualizerGUI
public class SortingVisualizerGUI extends JFrame {
    private int[] array;
    private SortingPanel sortingPanel;
    private JTextField inputField;
    private JTextField arraySizeField;
    private JComboBox<String> algorithmSelector;
    private JButton startButton, randomButton, resetButton;
    private JLabel statusLabel;
    
    public SortingVisualizerGUI() {
        setTitle("Sorting Algorithm Visualizer");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Initialize with default array
        array = new int[]{5, 3, 8, 1, 9, 4, 7, 2, 6};
        
        // Create components
        createControlPanel();
        createSortingPanel();
        createStatusPanel();
        
        setVisible(true);
    }
    
    private void createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(Color.LIGHT_GRAY);
        
        // Manual input
        controlPanel.add(new JLabel("Manual Input:"));
        inputField = new JTextField(20);
        controlPanel.add(inputField);
        
        JButton inputButton = new JButton("Set Array");
        inputButton.addActionListener(e -> setManualArray());
        controlPanel.add(inputButton);
        
        // Random generation
        controlPanel.add(new JLabel("Array Size:"));
        arraySizeField = new JTextField("10", 5);
        controlPanel.add(arraySizeField);
        
        randomButton = new JButton("Random");
        randomButton.addActionListener(e -> generateRandomArray());
        controlPanel.add(randomButton);
        
        // Algorithm selection
        controlPanel.add(new JLabel("Algorithm:"));
        algorithmSelector = new JComboBox<>(new String[]{"Selection Sort", "Insertion Sort"});
        controlPanel.add(algorithmSelector);
        
        // Control buttons
        startButton = new JButton("Start Sorting");
        startButton.addActionListener(e -> startSorting());
        controlPanel.add(startButton);
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetArray());
        controlPanel.add(resetButton);
        
        add(controlPanel, BorderLayout.NORTH);
    }
    
    private void createSortingPanel() {
        sortingPanel = new SortingPanel(array);
        add(sortingPanel, BorderLayout.CENTER);
    }
    
    private void createStatusPanel() {
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.WHITE);
        statusLabel = new JLabel("Ready to sort");
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);
    }
    
    private void setManualArray() {
        try {
            String input = inputField.getText().trim();
            String[] numbers = input.split(",");
            array = new int[numbers.length];
            
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i].trim());
            }
            
            sortingPanel.setArray(array);
            statusLabel.setText("Array set manually. Ready to sort.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Use format: 5,3,8,1,9");
        }
    }
    
    private void generateRandomArray() {
        try {
            int size = Integer.parseInt(arraySizeField.getText());
            if (size < 1 || size > 100) {
                JOptionPane.showMessageDialog(this, "Array size must be between 1 and 100");
                return;
            }
            
            Random rand = new Random();
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = rand.nextInt(100) + 1;
            }
            
            sortingPanel.setArray(array);
            statusLabel.setText("Random array generated. Ready to sort.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid array size!");
        }
    }
    
    private void startSorting() {
        String algorithm = (String) algorithmSelector.getSelectedItem();
        startButton.setEnabled(false);
        randomButton.setEnabled(false);
        statusLabel.setText("Sorting with " + algorithm + "...");
        
        Thread sortThread = new Thread(() -> {
            if (algorithm.equals("Selection Sort")) {
                selectionSort();
            } else {
                insertionSort();
            }
            
            SwingUtilities.invokeLater(() -> {
                statusLabel.setText("Sorting completed!");
                startButton.setEnabled(true);
                randomButton.setEnabled(true);
            });
        });
        sortThread.start();
    }
    
    private void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            sortingPanel.setCurrentIndices(i, minIndex);
            sleep(500);
            
            for (int j = i + 1; j < array.length; j++) {
                sortingPanel.setCurrentIndices(i, j);
                sleep(500);
                
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                sortingPanel.setArray(array);
            }
            
            sortingPanel.setSortedIndex(i);
        }
        sortingPanel.setSortedIndex(array.length - 1);
    }
    
    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            
            sortingPanel.setCurrentIndices(i, j);
            sleep(500);
            
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                sortingPanel.setArray(array);
                sortingPanel.setCurrentIndices(i, j);
                sleep(500);
                j--;
            }
            array[j + 1] = key;
            sortingPanel.setArray(array);
            sortingPanel.setSortedIndex(i);
        }
    }
    
    private void resetArray() {
        array = new int[]{5, 3, 8, 1, 9, 4, 7, 2, 6};
        sortingPanel.setArray(array);
        sortingPanel.reset();
        statusLabel.setText("Array reset. Ready to sort.");
    }
    
    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortingVisualizerGUI());
    }
}