package framework;

import java.util.Random;

public class RandomNumberUtil {

    private static final Random random = new Random();

    public static String generateSixDigitNumber() {
        int number = 100000 + random.nextInt(900000); // ensures 6-digit number
        return String.valueOf(number);
    }
}
