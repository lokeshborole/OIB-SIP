import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

class User {
    String name, email, phone, Username, pin;

    User() {

        Username = "@lokesh05";
        pin = "1234";
        name = "lokesh";
        email = "lokeshborolee2305@gmail.com";
        phone = "9737463242";
    }

}

class ATM_Interface extends User {

    static Scanner sc = new Scanner(System.in);
    static Map<Integer, String> history = new HashMap<>();

    public static void welcome() throws InterruptedException {

        System.out.println("\n------------- Welcome to ATM -------------\n");
        System.out.println("Please insert your debit card...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Recieved....");
        TimeUnit.SECONDS.sleep(1);

    }
    public static String input() throws InterruptedException {
        System.out.print("Enter Atm PIN (4 digits) : ");
        TimeUnit.SECONDS.sleep(1);
        String input_pin = sc.next();
        System.out.println("\nValidating..... please wait...");
        TimeUnit.MILLISECONDS.sleep(1250);
        return input_pin;
    }

    public static void main(String[] args) throws InterruptedException {
        String input_pin;
        try (Scanner scan = new Scanner(System.in)) {
            ATM_Interface user1 = new ATM_Interface();

            int balance = 500, withdraw_amount, deposit_amount, transfer_amount;
            String bank_account_no;

            welcome();
            input_pin = input();

            // if (input_pin.length() != 4) {
            // System.out.println("pin must contain 4 numeric characters");
            // System.exit(0);
            // } else if (input_pin.equals(user1.pin)) {

            // System.out.println("\nAuthorized Successfully \n");
            // TimeUnit.MILLISECONDS.sleep(500);
            // System.out.println("Name - " + user1.name);
            // TimeUnit.MILLISECONDS.sleep(200);

            // System.out.println("Email - " + user1.email);
            // TimeUnit.MILLISECONDS.sleep(200);

            // System.out.println("phone - " + user1.phone);
            // TimeUnit.MILLISECONDS.sleep(200);

            // System.out.println("Balance - " + balance+"");
            // System.out.println("------------------------------------------");
            // } else {
            // System.out.println("Incorrect pin \n\nTerminated...");
            // System.out.println("please Collect your card\n");
            // System.out.println("------------Thank you -----------\n");
            // System.exit(0);
            // }

            int attempt = 0;
            while (!(input_pin.equals(user1.pin))) {
                if (attempt < 2) {
                    System.out.println("Incorrect pin Please try again\n");
                    input_pin = input();
                    attempt++;
                } else {
                    System.out.println("too many attempts...");
                    System.out.println("please Collect your card\n");
                    System.out.println("------------Thank you -----------\n");
                    System.exit(0);
                }
            }
            System.out.println("\nAuthorized Successfully \n");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Name - " + user1.name);
            TimeUnit.MILLISECONDS.sleep(200);

            System.out.println("Email - " + user1.email);
            TimeUnit.MILLISECONDS.sleep(200);

            System.out.println("phone - " + user1.phone);
            TimeUnit.MILLISECONDS.sleep(200);

            System.out.println("Balance - " + balance+"");
            System.out.println("------------------------------------------");

            TimeUnit.SECONDS.sleep(1);
            System.out.println("Enter 1 for Withdraw");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.println("Enter 2 for Deposit");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.println("Enter 3 for Transfer");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.println("Enter 4 for Transaction History");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.println("Enter 5 for Check balance");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.println("Enter 6 for EXIT \n");
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("------------------------------------------");

            

            while (true) {

                System.out.print("Enter choice : ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount for withdraw: ");
                        withdraw_amount = scan.nextInt();

                        if (balance >= withdraw_amount) {
                            balance = balance - withdraw_amount;
                            history.put(withdraw_amount, "- amount Withdrawn");
                            System.out.println("Please collect your Money");
                            System.out.println("Updated Balance : " + balance);
                            System.out.println("");
                        }

                        else {
                            System.out.println("Insufficient Funds \n");
                        }

                        break;

                    case 2:

                        System.out.print("Enter amount to deposit: ");
                        deposit_amount = scan.nextInt();

                        balance += deposit_amount;

                        history.put(deposit_amount, "- amount Deposited");
                        System.out.println("Money deposited successfully");
                        System.out.println("Updated Balance : " + balance + "\n");
                        break;

                    case 3:
                        System.out.print("Enter amount to Transfer : ");
                        transfer_amount = scan.nextInt();
                        System.out.print("Enter bank account number (8 digits...): ");
                        bank_account_no = scan.next();

                        if (bank_account_no.length() != 8) {
                            System.out.println("\nAccount number must contain 8 numeric characters\n");
                            System.exit(0);
                        } else if (balance >= transfer_amount) {
                            balance -= transfer_amount;
                            System.out.println(transfer_amount + " Rupees transfered successfully to bank account : \""
                                    + bank_account_no + "\"");
                            history.put(transfer_amount, "- amount Transfered to account- \"" + bank_account_no + "\"");
                            System.out.println("Updated Balance : " + balance + "\n");
                        }

                        else {
                            System.out.println("Insufficient Funds \n");
                        }
                        break;

                    case 4:
                        System.out.println("\n--------------------Mini Statement--------------------\n");
                        for (Map.Entry<Integer, String> e : history.entrySet()) {
                            System.out.println(e.getKey() + " " + e.getValue());
                        }
                        System.out.println("");
                        break;

                    case 5:
                        System.out.println("Balance :" + balance);
                        System.out.println("");
                        break;

                    case 6:
                        System.out.println("Please collect your card \n\n--------THANK YOU------");
                        System.exit(0);

                    default:
                        System.out.println("INVALID CHOICE \n");
                }

            }
        } catch (Exception e) {
        }

    }

}