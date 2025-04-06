const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();
const [n, m] = input.split(' ').map(Number);

let answer = [];
let result = [];

function dfs(start) {
    if (result.length === m) {
        answer.push(result.join(' '));
        return;
    }

    for (let i = start; i <= n; i++) {
        result.push(i);     
        dfs(i + 1);         
        result.pop();      
    }
}

dfs(1);

console.log(answer.join('\n'));
