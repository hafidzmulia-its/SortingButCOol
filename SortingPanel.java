import javax.swing.*;
import java.awt.*;

public class SortingPanel extends JPanel {
    private int[] array;
    private int currentIndex1 = -1;
    private int currentIndex2 = -1;
    private int sortedUpTo = -1;
    
    public SortingPanel(int[] array) {
        this.array = array.clone();
        setBackground(Color.WHITE);
    }
    
    public void setArray(int[] array) {
        this.array = array.clone();
        repaint();
    }
    
    public void setCurrentIndices(int i, int j) {
        this.currentIndex1 = i;
        this.currentIndex2 = j;
        repaint();
    }
    
    public void setSortedIndex(int index) {
        this.sortedUpTo = index;
        repaint();
    }
    
    public void reset() {
        currentIndex1 = -1;
        currentIndex2 = -1;
        sortedUpTo = -1;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (array == null || array.length == 0) return;
        
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.length;
        
        // Find max absolute value for scaling
        int maxAbsValue = getMaxAbsValue();
        
        // Calculate middle line (x-axis position)
        int middleY = height / 2;
        
        // Draw x-axis (middle line)
        g.setColor(Color.BLACK);
        g.drawLine(0, middleY, width, middleY);
        g.drawString("0", 5, middleY - 5);
        
        // Available height for bars (half of panel minus margins)
        int availableHeight = (height / 2) - 40;
        
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int barHeight = (int) ((double) Math.abs(value) / maxAbsValue * availableHeight);
            int x = i * barWidth;
            int y;
            
            // Determine bar position based on positive or negative
            if (value >= 0) {
                // Positive: draw upward from middle
                y = middleY - barHeight;
            } else {
                // Negative: draw downward from middle
                y = middleY;
            }
            
            // Set color based on state
            if (i <= sortedUpTo) {
                g.setColor(Color.GREEN);
            } else if (i == currentIndex1 || i == currentIndex2) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }
            
            // Draw bar
            g.fillRect(x + 2, y, barWidth - 4, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x + 2, y, barWidth - 4, barHeight);
            
            // Draw value below the bar
            String valueStr = String.valueOf(value);
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(valueStr);
            
            if (value >= 0) {
                // Positive: draw above the bar
                g.drawString(valueStr, x + (barWidth - textWidth) / 2, y - 5);
            } else {
                // Negative: draw below the bar
                g.drawString(valueStr, x + (barWidth - textWidth) / 2, y + barHeight + 15);
            }
        }
        
        // Draw labels for positive and negative sides
        g.setColor(Color.GRAY);
        g.drawString("Positive →", width - 100, 20);
        g.drawString("Negative →", width - 100, height - 10);
    }
    
    private int getMaxAbsValue() {
        int maxAbs = Math.abs(array[0]);
        for (int value : array) {
            int abs = Math.abs(value);
            if (abs > maxAbs) {
                maxAbs = abs;
            }
        }
        return maxAbs == 0 ? 1 : maxAbs; // Avoid division by zero
    }
}