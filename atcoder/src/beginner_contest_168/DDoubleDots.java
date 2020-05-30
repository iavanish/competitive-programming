package beginner_contest_168;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DDoubleDots {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        queue.offer(1);
        isVisited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer next : adjList.get(node)) {
                if (!isVisited[next]) {
                    queue.offer(next);
                    isVisited[next] = true;
                    parent[next] = node;
                }
            }
        }

        boolean flag = true;
        for (int i = 2; i <= n; i++) {
            if (!isVisited[i]) {
                flag = false;
            }
        }

        if (!flag) {
            out.println("No");
        }
        else {
            out.println("Yes");
            for (int i = 2; i <= n; i++) {
                out.println(parent[i]);
            }
        }
    }

}
