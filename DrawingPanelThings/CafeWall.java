package DrawingPanelThings;

import java.awt.*;

public class CafeWall {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650, 400);
        Graphics g = panel.getGraphics();
        g.setColor(Color.RED);
        g.fill3DRect(200, 200, 100, 100, true);
    }
}
