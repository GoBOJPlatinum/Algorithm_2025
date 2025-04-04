function solution(n, computers) {
    let visited = new Array(n).fill(false);
    let networkCount = 0;

    function dfs(node) {
        visited[node] = true; // 현재 노드 방문 처리

        for (let i = 0; i < n; i++) {
            if (computers[node][i] === 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (!visited[i]) { // 방문하지 않은 노드라면 새로운 네트워크 발견
            dfs(i);
            networkCount++;
        }
    }

    return networkCount;
}


