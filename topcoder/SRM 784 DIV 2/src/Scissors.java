public class Scissors {

    public int openingTime(int N) {
        long two = 1;
        int time = 0;
        while (N > 0) {
            N -= two;
            two *= 2;
            time += 10;
        }

        return time;
    }

}
