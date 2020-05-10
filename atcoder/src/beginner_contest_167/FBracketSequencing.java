package beginner_contest_167;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FBracketSequencing {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        // ToDo
        int n = in.nextInt();
        PriorityQueue<Data> priorityQueue = new PriorityQueue<>();
        int totalOpen = 0;

        for (int i = 0; i < n; i++) {
            int open = 0;
            int close = 0;
            int maxClose = 0;

            int c;
            while ((c = in.read()) != -1) {
                if (c == '\n') {
                    break;
                }
                if (c == 40) {
                    open++;
                } else if (c == 41) {
                    close++;
                }
                maxClose = Math.max(maxClose, close - open);
            }
            if (maxClose > 0) {
                priorityQueue.offer(new Data(open, close, maxClose));
            } else {
                totalOpen += (open - close);
            }
        }

        boolean flag = true;
        while (!priorityQueue.isEmpty()) {
            List<Data> list = new ArrayList<>();
            Data data = priorityQueue.poll();
            while (!priorityQueue.isEmpty() && totalOpen < data.maxClose) {
                list.add(data);
                data = priorityQueue.poll();
            }
            if (totalOpen < data.maxClose) {
                flag = false;
                break;
            }
            totalOpen += (data.open - data.close);
            priorityQueue.addAll(list);
        }

        if (flag && totalOpen == 0) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }

    private static class Data implements Comparable<Data> {

        public int open;
        public int close;
        public int maxClose;

        public Data(int open, int close, int maxClose) {
            this.open = open;
            this.close = close;
            this.maxClose = maxClose;
        }

        @Override
        public int compareTo(Data data) {
            if (this.open - this.close != data.open - data.close) {
                return (data.open - data.close) - (this.open - this.close);
            }
            return this.maxClose - data.maxClose;
        }

    }

}
