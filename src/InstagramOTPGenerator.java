import java.util.ArrayList;
import java.util.List;

public class InstagramOTPGenerator {

    public static void main(String[] args) {
        int length = 6; // Change this to the desired OTP length
        long number = 123456; // Change this to the input number

        List<String> otpCombinations = generateOTPCombinations(length, number);
        System.out.println("Maximum possible OTP combinations:");
        for (String otp : otpCombinations) {
            System.out.println(otp);
        }
    }

    private static List<String> generateOTPCombinations(int length, long number) {
        List<String> combinations = new ArrayList<>();
        String numberString = String.valueOf(number);

        if (numberString.length() < length) {
            System.out.println("Input number is too short for the desired OTP length.");
            return combinations;
        }

        generateCombinations("", numberString, length, combinations);
        return combinations;
    }

    private static void generateCombinations(String current, String remaining, int length, List<String> result) {
        if (current.length() == length) {
            result.add(current);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char digit = remaining.charAt(i);
            String newCurrent = current + digit;
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generateCombinations(newCurrent, newRemaining, length, result);
        }
    }
}

// new verson coming soon for win rar.
