// Gavan Bess
// 12/17/2025
// AP CS A
// Lab #2b - Space Needle
//
// This program prints a scalable representation of the Seattle Space Needle to console

import java.lang.Math;
import java.lang.Runnable;

public class SpaceNeedle {

    public static final int SIZE = 4;
    public static final int NEEDLE_HEIGHT = SIZE;
    public static final int NUM_STAGES_TOP_BOTTOM_BASE = SIZE; // number of stages in the base, and the top and bottom of the "ufo" part
    public static final int MAX_WIDTH = 2 + (SIZE * 6);
    public static final int ELEVATOR_HEIGHT = SIZE * SIZE;
    public static final int ELEVATOR_WIDTH = Math.max(SIZE - 2, 0);

    private static void repeat(int num, Runnable thing) {
        for (int i = 0; i < num; i++) {
            thing.run();
        }
    }

    public static void main(String[] args) {
        printAntenna();
        printUFOTop();
        printUFOBottom();
        printAntenna();
        printElevator();
        printUFOTop();
    }

    public static void printAntenna() {
        repeat(NEEDLE_HEIGHT, () -> {
            System.out.println(" ".repeat((MAX_WIDTH - 2) / 2).concat("||"));
        });
    }

    public static void printElevator() {
        repeat(ELEVATOR_HEIGHT, () -> {
            System.out.println(
                " ".repeat((MAX_WIDTH - (SIZE * 2)) / 2).concat(
                    "|".concat("%".repeat(ELEVATOR_WIDTH)).concat("|").repeat(2)
                )
            );
        });
    }

    public static void printUFOTop() {
        for (int i = 0; i < SIZE; i++) {
            int spaces = (MAX_WIDTH / 2) - (4 + (3 * i));
            String side = "__/".concat(":".repeat(i * 3)).concat("|");
            System.out.println(
                " ".repeat(spaces)
                    .concat(side)
                    .concat(
                        new StringBuilder(side)
                            .replace(2, 3, "\\")
                            .reverse()
                            .toString()
                    )
            );
        }

        System.out.println("|".concat("\"".repeat(MAX_WIDTH - 2)).concat("|"));
    }

    public static void printUFOBottom() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(
                " ".repeat(i * 2).concat(
                    "\\_".concat(
                        "/\\".repeat(((MAX_WIDTH - 4) - (i * 4)) / 2)
                    ).concat("_/")
                )
            );
        }
    }
}
