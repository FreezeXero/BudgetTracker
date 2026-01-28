import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while (running){
            System.out.println("\n=== BUDGET TRACKER ===");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Spending by Category");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    viewTransactions();
                    break;
                case 4:
                    viewByCategory();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }


        }
        System.out.println("Thanks for using Budget Tracker!");
        scanner.close();



    }

    static void addIncome() {
        System.out.print("Enter income amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter description (e.g., Salary, Freelance): ");
        String description = scanner.nextLine();

        transactionTypes.add("INCOME");
        transactionAmounts.add(amount);
        transactionCategories.add("Income");
        transactionDescriptions.add(description);

        System.out.println("✓ Income added: $" + amount);

    }

    static void addExpense() {
        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nCategories:");
        System.out.println("1. Food");
        System.out.println("2. Rent");
        System.out.println("3. Transport");
        System.out.println("4. Entertainment");
        System.out.println("5. Other");
        System.out.print("Choose category: ");

        int catChoice = scanner.nextInt();
        scanner.nextLine();

        String category = "";
        switch (catChoice) {
            case 1 -> category = "Food";
            case 2 -> category = "Rent";
            case 3 -> category = "Transport";
            case 4 -> category = "Entertainment";
            case 5 -> category = "Other";
            default -> category = "Other";
        }

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        transactionTypes.add("EXPENSE");
        transactionAmounts.add(amount);
        transactionCategories.add(category);
        transactionDescriptions.add(description);

        System.out.println("✓ Expense added: $" + amount + " (" + category + ")");
    }

    static void viewTransactions() {
        if (transactionTypes.size() == 0) {
            System.out.println("\nNo transactions yet!");
            return;
        }

        System.out.println("\n=== ALL TRANSACTIONS ===");
        for (int i = 0; i < transactionTypes.size(); i++) {
            System.out.printf("%d. %s - $%.2f - %s - %s\n",
                    i + 1,
                    transactionTypes.get(i),
                    transactionAmounts.get(i),
                    transactionCategories.get(i),
                    transactionDescriptions.get(i)
            );
        }
    }

    static void viewByCategory() {
        if (transactionTypes.size() == 0) {
            System.out.println("\nNo transactions yet!");
            return;
        }

        System.out.println("\n=== SPENDING BY CATEGORY ===");

        String[] categories = {"Food", "Rent", "Transport", "Entertainment", "Other"};

        for (String cat : categories) {
            double total = 0;
            for (int i = 0; i < transactionTypes.size(); i++) {
                if (transactionCategories.get(i).equals(cat) && transactionTypes.get(i).equals("EXPENSE")) {
                    total += transactionAmounts.get(i);
                }
            }
            if (total > 0) {
                System.out.printf("%s: $%.2f\n", cat, total);
            }
        }

        // Show total income
        double totalIncome = 0;
        for (int i = 0; i < transactionTypes.size(); i++) {
            if (transactionTypes.get(i).equals("INCOME")) {
                totalIncome += transactionAmounts.get(i);
            }
        }

        // Show total expenses
        double totalExpenses = 0;
        for (int i = 0; i < transactionTypes.size(); i++) {
            if (transactionTypes.get(i).equals("EXPENSE")) {
                totalExpenses += transactionAmounts.get(i);
            }
        }

        System.out.println("\n--- SUMMARY ---");
        System.out.printf("Total Income: $%.2f\n", totalIncome);
        System.out.printf("Total Expenses: $%.2f\n", totalExpenses);
        System.out.printf("Balance: $%.2f\n", totalIncome - totalExpenses);
    }



    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> transactionTypes = new ArrayList<>();
    static ArrayList<Double> transactionAmounts = new ArrayList<>();
    static ArrayList<String> transactionCategories = new ArrayList<>();
    static ArrayList<String> transactionDescriptions = new ArrayList<>();



}



