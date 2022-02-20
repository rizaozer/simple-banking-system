import java.util.Scanner;

public class Bank {

    private static BankAccount account1;

    public static void createAccount() {
        account1 = new BankAccount();
    }

    void run() {
        createAccount();
        boolean flag = true;
        boolean isLoggedIn;

        while (flag) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int decision = scanner.nextInt();
            switch (decision) {
                // create a bank account
                case 1:
                    System.out.println("Your card has been created!");
                    System.out.println(account1);
                    break;
                // login account
                case 2:
                    System.out.println("Enter your card number: ");
                    scanner.nextLine();
                    String cardNumber = scanner.nextLine();
                    if (account1.getCardNumber().equals(cardNumber)) {
                        System.out.println("Enter your pin: ");
                        String cardPin = scanner.nextLine();
                        if (account1.getCardPin().equals(cardPin)) {
                            isLoggedIn = true;
                            System.out.println("You have successfully logged in!");
                            while (isLoggedIn) {
                                loginMenu();
                                decision = scanner.nextInt();
                                switch (decision) {
                                    case 1 ->
                                        // balance info
                                        balanceInfo();
                                    case 2 -> {
                                        // log out
                                        System.out.println("You have successfully logged out!");
                                        isLoggedIn = false;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Wrong card number or PIN!");
                            continue;
                        }
                    } else {
                        System.out.println("Wrong card number or PIN!");
                        continue;
                    }

                case 0:
                    // exit
                    System.out.println("Bye!");
                    flag = false;
                    break;
            }
        }
    }

        public static void menu () {
            System.out.println();
            System.out.println("""
                    1. Create an account\s
                    2. Log into account\s
                    0. Exit""");
        }

        public static void loginMenu () {
            System.out.println();
            System.out.println("""
                     1. Balance\s
                     2. Log out\s
                     0. Exit""");
        }

        public static void balanceInfo() {
            System.out.println("Balance: " + account1.getBalance());
        }


    }


