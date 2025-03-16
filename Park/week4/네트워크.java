import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i);
                networkCount++;
            }
        }

        return networkCount;
    }

    private void bfs(int[][] computers, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next = 0; next < computers.length; next++) {
                if (computers[node][next] == 1 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
