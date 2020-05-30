package codeforces_round_642_div_3;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class DConstructingTheArray {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            int[] a = new int[n+1];
            PriorityQueue<Interval> priorityQueue = new PriorityQueue<>();
            priorityQueue.offer(new Interval(1, n));
            int i = 1;
            while (!priorityQueue.isEmpty()) {
                Interval interval = priorityQueue.poll();
                int curr;
                if ((interval.right - interval.left + 1) % 2 != 0) {
                    curr = (interval.left + interval.right) / 2;

                } else {
                    curr = (interval.left + interval.right - 1) / 2;
                }
                a[curr] = i++;
                if (interval.left < curr) {
                    priorityQueue.offer(new Interval(interval.left, curr-1));
                }
                if (curr < interval.right) {
                    priorityQueue.offer(new Interval(curr+1, interval.right));
                }
            }

            for (i = 1; i <= n; i++) {
                out.printf("%d ", a[i]);
            }
            out.println();
        }
    }

    private static class Interval implements Comparable<Interval> {
        public int left;
        public int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Interval interval) {
            if ((this.right - this.left + 1) != (interval.right - interval.left + 1)) {
                return (interval.right - interval.left + 1) - (this.right - this.left + 1);
            }
            return this.left - interval.left;
        }
    }

}
