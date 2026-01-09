// Gavan Bess
// 01/07/2026
// AP CS A
// Lab #5 - Budgeter
//
// This program queries a user for income and spending information, and outputs budget information in return

import java.util.Scanner;

public class Budgeter {

    public static final int DAYS_IN_MONTH = 31;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("This program asks you for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");

        double income = getIncome(s);
        double expenses = getExpenses(s);

        printNetMonthlyIncomeStats(income, expenses);
    }

    public static double getIncome(Scanner s) {
        System.out.println();
        System.out.print("How many catagories of income? ");
        int numCatagories = s.nextInt();

        double income = 0.;

        for (int i = 0; i < numCatagories; i++) {
            System.out.print("    Next income amount? $");
            income += s.nextDouble();
        }

        return income;
    }

    public static double getExpenses(Scanner s) {
        System.out.println();
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int userTimeIntervalChoice = s.nextInt();

        System.out.print("How many catagories of expense? ");
        int numCatagories = s.nextInt();

        double expenses = 0.;

        for (int i = 0; i < numCatagories; i++) {
            System.out.print("    Next expense amount? $");
            expenses += s.nextDouble();
        }

        if (userTimeIntervalChoice == 2) {
            expenses *= DAYS_IN_MONTH;
        }

        return expenses;
    }

    public static void printNetMonthlyIncomeStats(
        double income,
        double expenses
    ) {
        double roundedIncome = ((double) ((int) (income * 100))) / 100; // easy truncate to the 2nd decimal place
        double roundedExpenses = ((double) ((int) (expenses * 100))) / 100;
        double roundedIncomePerDay =
            ((double) ((int) ((roundedIncome * 100) / DAYS_IN_MONTH))) / 100;
        double roundedExpensesPerDay =
            ((double) ((int) ((roundedExpenses * 100) / DAYS_IN_MONTH))) / 100;

        System.out.println();
        System.out.println(
            "Total income = $" +
                String.valueOf(roundedIncome) +
                " ($" +
                String.valueOf(roundedIncomePerDay) +
                "/day)"
        );
        System.out.println(
            "Total expenses = $" +
                String.valueOf(roundedExpenses) +
                " ($" +
                String.valueOf(roundedExpensesPerDay) +
                "/day)"
        );
        System.out.println();

        double differenceInIncomeVSExpenses =
            ((double) ((int) ((roundedIncome - roundedExpenses) * 100))) / 100;

        if (differenceInIncomeVSExpenses <= 0) {
            System.out.println(
                "You spent $" +
                    Math.abs(differenceInIncomeVSExpenses) +
                    " more than you earned this month."
            );
        } else {
            System.out.println(
                "You earned $" +
                    Math.abs(differenceInIncomeVSExpenses) +
                    " more than you spent this month."
            );
        }

        if (differenceInIncomeVSExpenses > 250) {
            System.out.println("You're a big saver.");
            System.out.println("Maybe try investing some of this money.");
        } else if (differenceInIncomeVSExpenses > 0) {
            System.out.println("You're a saver.");
            System.out.println("You can always save more.");
        } else if (differenceInIncomeVSExpenses > -250) {
            System.out.println("You're a spender.");
            System.out.println("Try harder next month.");
        } else {
            System.out.println("You're a big spender.");
            System.out.println("You need to reconsider your life decisions.");
        }
    }

    public static void printMessage() {}
}
