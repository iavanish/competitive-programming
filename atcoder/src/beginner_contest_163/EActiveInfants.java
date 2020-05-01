package beginner_contest_163;

import commons.FastReader;

import java.io.PrintWriter;

public class EActiveInfants {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        Infant[] a = new Infant[n+1];
        a[0] = new Infant(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            a[i] = new Infant(in.nextLong(), i);
        }

        /*
         *  ToDo
         *  Can't even understand the editorial right now :(
         */
    }

    private static class Infant implements Comparable<Infant> {

        public long a;
        public int index;

        public Infant(long a, int index) {
            this.a = a;
            this.index = index;
        }

        @Override
        public int compareTo(Infant infant) {
            return (int) (infant.a - this.a);
        }

    }

}
