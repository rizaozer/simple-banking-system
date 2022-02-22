import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;

public class BankAccount {

    private final String cardNumber;
    private final String cardPin;
    private double balance;

    public BankAccount() {
        this.cardNumber = generateCardNumber();
        this.cardPin = generatePin();
    }

    public static String generateCardNumber() {
        String k = "400000";
        String l = valueOf(10000 + new Random().nextInt(99999));
        String m = valueOf(1000 + new Random().nextInt(9999));
        return k + l + m;
    }

    public static int findTheLastNumber(String cardNumber) {
        int[] numbersArray = new int[cardNumber.length()];

        for(int i = 0; i < cardNumber.length(); i++){
            numbersArray[i] = Character.getNumericValue(cardNumber.charAt(i));
        }
        return 0;

    }

    public static String generatePin() {
        return valueOf(1000 + new Random().nextInt(9999));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    @Override
    public String toString() {
        return "Your card number: " + cardNumber + "\n" +
                "Your card pin: " + cardPin;
    }
}
