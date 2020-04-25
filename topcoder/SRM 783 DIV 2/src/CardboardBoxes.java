public class CardboardBoxes {

    public long count(long S) {
        if (S % 2 != 0) {
            return 0;
        }

        S /= 2;
        long res = 0;
        for (long i = 2; i * i <= S; i++) {
            if (S % i == 0) {
                res += count(S, i);
                if (i < S/i) {
                    res += count(S, S/i);
                }
            }
        }

        return res;
    }

    private long count(long S, long lPlusW) {
        long hPlusW = S / lPlusW;
        return Math.min(hPlusW-1, lPlusW/2);
    }

}
