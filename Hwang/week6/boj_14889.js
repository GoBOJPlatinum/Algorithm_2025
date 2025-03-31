const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0];
const board = input.slice(1).map(line => line.split(' ').map(Number));
const visited = Array(N).fill(false);

let minDiff = Infinity;

function dfs(depth, start) {
  if (depth === N / 2) {
    let teamStart = 0;
    let teamLink = 0;

    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (visited[i] && visited[j]) {
          teamStart += board[i][j];
        }
        if (!visited[i] && !visited[j]) {
          teamLink += board[i][j];
        }
      }
    }

    const diff = Math.abs(teamStart - teamLink);
    minDiff = Math.min(minDiff, diff);
    return;
  }

  for (let i = start; i < N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      dfs(depth + 1, i + 1);
      visited[i] = false;
    }
  }
}

dfs(0, 0);
console.log(minDiff);
