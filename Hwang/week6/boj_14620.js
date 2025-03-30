const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0];
const board = input.slice(1).map(row => row.split(' ').map(Number));
const visited = Array.from({ length: N }, () => Array(N).fill(false));

const dir = [[0,0], [1,0], [-1,0], [0,1], [0,-1]];
let minCost = Infinity;

function isValid(x, y) {
  return dir.every(([dx, dy]) => {
    const nx = x + dx;
    const ny = y + dy;
    return nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny];
  });
}

function setFlower(x, y, flag) {
  let cost = 0;
  for (const [dx, dy] of dir) {
    const nx = x + dx;
    const ny = y + dy;
    visited[nx][ny] = flag;
    cost += board[nx][ny];
  }
  return cost;
}

function dfs(count, sum) {
  if (count === 3) {
    minCost = Math.min(minCost, sum);
    return;
  }

  for (let i = 1; i < N - 1; i++) {
    for (let j = 1; j < N - 1; j++) {
      if (isValid(i, j)) {
        const cost = setFlower(i, j, true);
        dfs(count + 1, sum + cost);
        setFlower(i, j, false);
      }
    }
  }
}

dfs(0, 0);
console.log(minCost);
