package framework;

public class instrumentNoGenerator {

    // Returns a 6-digit random number as a String with leading zeros
    public static String generateSixDigitNumber() {
        int number = (int)(Math.random() * 999999) + 1;
        return String.format("%06d", number);
    }
}