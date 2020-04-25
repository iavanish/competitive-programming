public class MaximumBalances {

    public int solve(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
        }

        long min = Math.min(open, close);
        return (int) (min * (min + 1)) / 2;
    }

}
