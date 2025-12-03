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
        int maxValue = getMaxValue();
        
        for (int i = 0; i < array.length; i++) {
            int barHeight = (int) ((double) array[i] / maxValue * (height - 50));
            int x = i * barWidth;
            int y = height - barHeight - 30;
            
            // Set color based on state
            if (i <= sortedUpTo) {
                g.setColor(Color.GREEN);
            } else if (i == currentIndex1 || i == currentIndex2) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }
            
            g.fillRect(x + 2, y, barWidth - 4, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x + 2, y, barWidth - 4, barHeight);
            
            // Draw value
            String value = String.valueOf(array[i]);
            g.drawString(value, x + barWidth / 2 - 10, height - 10);
        }
    }
    
    private int getMaxValue() {
        int max = array[0];
        for (int value : array) {
            if (value > max) max = value;
        }
        return max;
    }
}