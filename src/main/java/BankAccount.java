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
        String k = valueOf(1000 + new Random().nextInt(9999));
        String l = valueOf(1000 + new Random().nextInt(9999));
        String m = valueOf(1000 + new Random().nextInt(9999));
        String n = valueOf(100 + new Random().nextInt(999));

        String cardNumber = k + l + m + n;

        long cardNumberLong = Long.parseLong(cardNumber);

        long sum = 0;
        while(cardNumberLong > 0) {
            long temp = cardNumberLong % 10;
            cardNumberLong = cardNumberLong / 10;
            sum = sum + temp;
        }

        long lastNumber;
        if(sum % 10 != 0) {
            lastNumber = 10 - (sum % 10);
        } else {
            lastNumber = 0;
        }

        String lastNumberString = Long.toString(lastNumber);

        return k + l + m + n + lastNumberString;
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
