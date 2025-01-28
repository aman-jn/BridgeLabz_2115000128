import java.util.HashSet;

public class OTPGenerator {

    public static String generateOTP() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }
    public static String[] generateMultipleOTPs(int count) {
        String[] otps = new String[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }
    public static boolean areOTPsUnique(String[] otps) {
        HashSet<String> uniqueOTPs = new HashSet<>();
        for (String otp : otps) {
            uniqueOTPs.add(otp);
        }
        return uniqueOTPs.size() == otps.length;
    }

    public static void main(String[] args) {
        int count = 10;
        String[] otps = generateMultipleOTPs(count);
        System.out.println("Generated OTPs:");
        for (String otp : otps) {
            System.out.println(otp);
        }
        boolean unique = areOTPsUnique(otps);
        System.out.println("\nAre all OTPs unique? " + unique);
    }
}