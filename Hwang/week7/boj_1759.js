const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [L, C] = input[0].split(' ').map(Number);
const chars = input[1].split(' ').sort(); // 오름차순 정렬

const moeum = ['a', 'e', 'i', 'o', 'u'];
let result = [];

function checkPw(password) {
    let moeumCount = 0;
    let consonantCount = 0;
    for (const ch of password) {
        if (moeum.includes(ch)) moeumCount++;
        else consonantCount++;
    }
    return moeumCount >= 1 && consonantCount >= 2;
}

function dfs(start, path) {
    if (path.length === L) {
        if (checkPw(path)) {
            result.push(path.join(''));
        }
        return;
    }

    for (let i = start; i < C; i++) {
        path.push(chars[i]);
        dfs(i + 1, path);
        path.pop();
    }
}

dfs(0, []);
console.log(result.join('\n'));
