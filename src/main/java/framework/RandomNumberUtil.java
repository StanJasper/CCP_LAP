package framework;

import java.util.Random;

public class RandomNumberUtil {

    private static final Random random = new Random();

    public static String generateSixDigitNumber() {
        int number = 100000 + random.nextInt(900000); // ensures 6-digit number
        return String.valueOf(number);
    }

    public static String generateTenDigitChallanNumber() {
        long number = 1111111111L + (long)(random.nextDouble() * (9999999999L - 1111111111L));
        return String.valueOf(number);
    }
}
