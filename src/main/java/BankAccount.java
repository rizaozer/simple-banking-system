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

    // To generate credit card number
    public static String generateCardNumber() {
        String k = "400000";
        String l = valueOf(10000 + new Random().nextInt(99999));
        String m = valueOf(1000 + new Random().nextInt(9999));
        return k + l + m + findTheLastNumber(k + l + m);
    }

    // find the last number by using luhn algorithm
    public static int findTheLastNumber(String cardNumber) {

        int[] numbers = new int[cardNumber.length()];

        for(int i = 0; i < cardNumber.length(); i++){
            numbers[i] = Character.getNumericValue(cardNumber.charAt(i));
        }

        for (int i = 0; i < 15; i += 2) {
                if(numbers[i] * 2 > 9) {
                    numbers[i] = (numbers[i] * 2) - 9;
                } else {
                    numbers[i] = numbers[i] * 2;
                }
        }
        return generateLastNumber(numbers);
    }

    // To generate last number after luhn algorithm
    public static int generateLastNumber(int [] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (sum % 10 != 0) ?  10 - sum % 10 :  0;
    }

    // To generate credit card number
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
