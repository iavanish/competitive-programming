public class EllysWhatDidYouGet {

    public int getCount(int N) {
        int count = 0;

        for (long x = 1; x <= 50; x++) {
            for (long y = 1; y <= 50; y++) {
                for (long z = 1; z <= 50; z++) {
                    long target = calculate(x, y, z, 1);
                    boolean flag = true;
                    for (long n = 2; n <= N; n++) {
                        if (calculate(x, y, z, n) != target) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long calculate(long x, long y, long z, long n) {
        long temp = (n * x + y) * z;
        long result = 0;
        while (temp > 0) {
            result += temp % 10;
            temp /= 10;
        }
        return result;
    }

}
