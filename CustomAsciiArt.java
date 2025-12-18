// Gavan Bess
// 12/17/2025
// AP CS A
// Lab #2a - Custom Ascii Art
//
// This program prints Moon phase ascii art to console

import java.util.Timer;
import java.util.TimerTask;
import java.lang.Runtime;
import java.lang.Thread;

public class CustomAsciiArt {

    public static final String[] MOON_ART = {
        "\u001b[1A\u001b[4D/.......\\\u001b[10D\u001b[1B|.........|\u001b[11D\u001b[1B|.........|\u001b[10D\u001b[1B\\......./",
        "\u001b[1A\u001b[4D/.....OO\\\u001b[10D\u001b[1B|.......OO|\u001b[11D\u001b[1B|.......OO|\u001b[10D\u001b[1B\\.....OO/",
        "\u001b[1A\u001b[4D/...OOOO\\\u001b[10D\u001b[1B|....OOOOO|\u001b[11D\u001b[1B|....OOOOO|\u001b[10D\u001b[1B\\...OOOO/",
        "\u001b[1A\u001b[4D/..OOOOO\\\u001b[10D\u001b[1B|..OOOOOOO|\u001b[11D\u001b[1B|..OOOOOOO|\u001b[10D\u001b[1B\\..OOOOO/",
        "\u001b[1A\u001b[4D/OOOOOOO\\\u001b[10D\u001b[1B|OOOOOOOOO|\u001b[11D\u001b[1B|OOOOOOOOO|\u001b[10D\u001b[1B\\OOOOOOO/",
        "\u001b[1A\u001b[4D/OOOOO..\\\u001b[10D\u001b[1B|OOOOOOO..|\u001b[11D\u001b[1B|OOOOOOO..|\u001b[10D\u001b[1B\\OOOOO../",
        "\u001b[1A\u001b[4D/OOOO...\\\u001b[10D\u001b[1B|OOOOO....|\u001b[11D\u001b[1B|OOOOO....|\u001b[10D\u001b[1B\\OOOO.../",
        "\u001b[1A\u001b[4D/OO.....\\\u001b[10D\u001b[1B|OO.......|\u001b[11D\u001b[1B|OO.......|\u001b[10D\u001b[1B\\OO...../",
    };

    static volatile int frame = 0;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\u001b[?25h");
        }));


        System.out.print("\u001b[?25l");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("\u001b[4A\u001b[20C");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.print(MOON_ART[frame%8]);
                System.out.print("\u001b[2A\u001b[5D");
                frame++;
            }
        }, 0, 125);
    }
}
