// Gavan Bess
// 12/26/2025
// AP CS A
// Lab #3 - Cafe Wall
//
// Draws the "cafe wall" graphic using the drawing panel

package DrawingPanelThings;

import java.awt.*;

public class CafeWall {
    public static final int GRID_ROW_SPACING = 2;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650, 400);
        Graphics g = panel.getGraphics();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 650, 400);

        drawRow(g, 4, 20, 0, 0);
        drawRow(g, 5, 30, 50, 70);

        drawGrid(g, 10, 150, 4, 8, 0, 25);
        drawGrid(g, 250, 200, 3, 6, 10, 25);
        drawGrid(g, 425, 180, 5, 10, 10, 20);
        drawGrid(g, 400, 20, 2, 4, 35, 35);
    }

    public static void drawRow(Graphics g, int n, int size, int startX, int startY) {
        for (int i = 0; i < n; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(startX + (i*2*size), startY, size, size);
            g.setColor(Color.BLUE);
            g.drawLine(startX + (i*2*size), startY, startX + (i*2*size) + size, startY+size);
            g.drawLine(startX + (i*2*size) + size, startY, startX + (i*2*size), startY+size);
            g.setColor(Color.WHITE);
            g.fillRect(startX + (((2*i)+1)*size), startY, size, size);
        }
    }

    public static void drawGrid(Graphics g, int startX, int startY, int cols, int rows, int stagger, int boxSize) {
        for (int i = 0; i < rows; i++) {
            drawRow(g, cols, boxSize, startX+((i%2)*stagger), startY+(i*(boxSize+GRID_ROW_SPACING)));
        }
    }
}
