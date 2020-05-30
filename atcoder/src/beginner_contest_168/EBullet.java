package beginner_contest_168;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class EBullet {

    private long[] powersOfTwo;
    private final long mod = 1_000_000_007;

    private void populatePowersOfTwo(int n) {
        powersOfTwo = new long[n + 1];
        powersOfTwo[0] = 1;
        for (int i = 1; i <= n; i++) {
            powersOfTwo[i] = (powersOfTwo[i - 1] * 2) % mod;
        }
    }

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        populatePowersOfTwo(n);

        Map<Pair, Integer> pairs = new LinkedHashMap<>();
        Map<Pair, Integer> copy = new HashMap<>();
        int countA0 = 0;
        int countB0 = 0;
        for (int i = 0; i < n; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            if (a == 0 && b != 0) {
                countA0++;
            } else if (a != 0 && b == 0) {
                countB0++;
            }
            Pair pair = new Pair(a, b);
            pairs.put(pair, pairs.getOrDefault(pair, 0) + 1);
            long gcd = gcd(a, b);
            pair = new Pair(a / gcd, b / gcd);
            copy.put(pair, copy.getOrDefault(pair, 0) + 1);
        }

        long max = powersOfTwo[n] - 1;

        for (Map.Entry<Pair, Integer> entry : pairs.entrySet()) {
            long a = entry.getKey().a;
            long b = entry.getKey().b;
            long gcd = gcd(a, b);
            long copyA = a / gcd;
            long copyB = b / gcd;
            if (!copy.containsKey(new Pair(copyA, copyB))) {
                continue;
            }
            if (a == 0 && b == 0) {
                max -= powersOfTwo[n - 1];
                max %= mod;
            } else if (a == 0 && b != 0 && countA0 > 0) {
                max -= countB0 * powersOfTwo[n - 2];
                max %= mod;
                countA0--;
            } else if (a != 0 && b == 0 && countB0 > 0) {
                max -= countA0 * powersOfTwo[n - 2];
                max %= mod;
                countB0--;
            } else {
                int count = copy.getOrDefault(new Pair(-copyB, copyA), 0);
                max -= count * entry.getValue() * powersOfTwo[n - entry.getValue() - 1];
                max %= mod;
                count = copy.getOrDefault(new Pair(copyB, -copyA), 0);
                max -= count * entry.getValue() * powersOfTwo[n - entry.getValue() - 1];
                max %= mod;
            }
            Pair pair = new Pair(copyA, copyB);
            int val = copy.get(pair) - entry.getValue();
            if (val <= 0) {
                copy.remove(pair);
            } else {
                copy.put(pair, val);
            }
        }

        out.println(max);
    }

    private long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private static class Pair {

        public long a;
        public long b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

    }

}
