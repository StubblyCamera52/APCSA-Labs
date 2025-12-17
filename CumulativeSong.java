// Gavan Bess
// 12/16/2025
// AP CS A
// Lab #1 - Cumulative Song
//
// This program prints the "Their was once an old woman..." song to console

public class CumulativeSong {

    public static void main(String[] args) {
        printVerse("", new String[] { "fly" });
        printVerse(
            "That wriggled and iggled and jiggled inside her.",
            new String[] { "fly", "spider" }
        );
        printVerse(
            "How absurd to swallow a bird.",
            new String[] { "fly", "spider", "bird" }
        );
        printVerse(
            "Imagine that to swallow a cat.",
            new String[] { "fly", "spider", "bird", "cat" }
        );
        printVerse(
            "What a hog to swallow a dog.",
            new String[] { "fly", "spider", "bird", "cat", "dog" }
        );
        printVerse(
            "",
            new String[] { "fly", "spider", "bird", "cat", "dog", "horse" }
        );
    }

    public static void printVerse(
        String swallowedEntityLine,
        String[] swallowedEntities
    ) {
        System.out.println(
            "There was an old woman who swallowed a ".concat(
                swallowedEntities[swallowedEntities.length - 1]
            ).concat(",")
        );

        if (swallowedEntities[swallowedEntities.length - 1] == "horse") {
            System.out.println("She died of course.");
            return;
        }

        if (swallowedEntityLine != "") {
            System.out.println(swallowedEntityLine);
        }

        for (int i = swallowedEntities.length - 1; i > 0; i--) {
            System.out.println(
                "She swallowed the ".concat(swallowedEntities[i])
                    .concat(" to catch the ")
                    .concat(swallowedEntities[i - 1])
                    .concat(",")
            );
        }

        System.out.println(
            "I don't know why she swallowed that ".concat(
                swallowedEntities[0]
            ).concat(",")
        );
        System.out.println("Perhaps she'll die.");
        System.out.println("");
    }
}
