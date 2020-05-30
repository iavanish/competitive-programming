public class CutTheCube {

    public int findWinner(int L, int B, int H) {
        int a = L * B * H;
        if (a % 2 == 0) {
            return 1;
        }
        return 2;
    }

    public int findWinner1(int L, int B, int H) {
        long a = (long) L * (long) B * (long) H;

        if (a % 2 == 0) {
            return 1;
        }
        return 2;
    }

}
