const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
const N = parseInt(input[0]);
const M = parseInt(input[1]);

const visited = Array(N + 1).fill(false);
const result = [];

function dfs(path) {
  if (path.length === M) {
    console.log(path.join(' '));
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      dfs([...path, i]);
      visited[i] = false;
    }
  }
}

dfs([]);
