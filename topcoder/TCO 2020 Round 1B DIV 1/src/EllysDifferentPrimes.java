import java.util.Arrays;

public class EllysDifferentPrimes {

    private final int maxN = 50000000 * 2 + 1;
    private boolean[] isPrime;

    public int getClosest(int N) {
        sieveOfEratosthenes();

        int left = N;
        int right = N;
        while (true) {
            if (isPrime[left] && hasDifferentDigits(left)) {
                return left;
            }
            if (isPrime[right] && hasDifferentDigits(right)) {
                return right;
            }
            left--;
            right++;
        }
    }

    private boolean hasDifferentDigits(int n) {
        boolean[] seen = new boolean[10];
        while (n > 0) {
            int remainder = n % 10;
            if (seen[remainder]) {
                return false;
            }
            seen[remainder] = true;
            n /= 10;
        }
        return true;
    }

    private void sieveOfEratosthenes() {
        isPrime = new boolean[maxN];
        Arrays.fill(isPrime, 2, maxN, true);
        for (int i = 2; i * i <= maxN; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < maxN; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }

}
