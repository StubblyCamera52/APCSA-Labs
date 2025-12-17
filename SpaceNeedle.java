import java.lang.Math;
import java.lang.Runnable;

public class SpaceNeedle {

    public static final int SIZE = 4;
    public static final int NEEDLE_HEIGHT = SIZE;
    public static final int NUM_STAGES_TOP_BOTTOM_BASE = SIZE; // number of stages in the base, and the top and bottom of the "ufo" part
    public static final int MAX_WIDTH = 2 + (SIZE * 6);
    public static final int ELEVATOR_HEIGHT = (int) Math.pow(2, SIZE);

    private static void repeat(int num, Runnable thing) {
        for (int i = 0; i < num; i++) {
            thing.run();
        }
    }

    public static void main(String[] args) {
        printAntenna();
    }

    public static void printAntenna() {
        repeat(NEEDLE_HEIGHT, () -> {System.out.println(" ".repeat((MAX_WIDTH-2)/2).concat("||"));});
    }
    
    public static void printUFOThing() {
        
    }
}
