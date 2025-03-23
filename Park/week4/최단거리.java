import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 상, 하, 좌, 우 이동
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m]; // 크기 동적 할당

        return bfs(maps, visited, n, m);
    }

    private int bfs(int[][] maps, int[][] visited, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 시작 위치 (y, x, 거리)
        visited[0][0] = 1; // 방문 표시

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1], dist = cur[2];

            // 도착하면 거리 반환
            if (y == n - 1 && x == m - 1) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 내 & 벽이 아님 & 방문하지 않은 곳이라면 이동 가능
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && maps[ny][nx] == 1 && visited[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx, dist + 1});
                    visited[ny][nx] = 1; // 방문 처리
                }
            }
        }

        // 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
