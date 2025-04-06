const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const N = Number(input[0]);
const T = [];
const P = [];

for (let i = 1; i <= N; i++) {
    const [t, p] = input[i].split(' ').map(Number);
    T.push(t);
    P.push(p);
}

let maxProfit = 0;

function dfs(day, sum) {
    if (day >= N) {
        maxProfit = Math.max(maxProfit, sum);
        return;
    }

    if (day + T[day] <= N) {
        dfs(day + T[day], sum + P[day]);
    }

    dfs(day + 1, sum);
}

// 0일부터 시작
dfs(0, 0);

console.log(maxProfit);
