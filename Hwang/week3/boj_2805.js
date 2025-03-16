const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on("line", function (line) {
    input.push(line);
}).on("close", function () {
    let [N, M] = input[0].split(" ").map(Number);
    let trees = input[1].split(" ").map(Number);

    let left = 0;
    let right = Math.max(...trees);
    let answer = 0;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let sum = trees.reduce((acc, tree) => acc + Math.max(tree - mid, 0), 0);

        if (sum >= M) {
            answer = mid;
            left = mid + 1; // 더 높은 절단 높이를 찾아야 함
        } else {
            right = mid - 1; // 절단 높이를 줄여야 충분한 나무를 얻을 수 있음
        }
    }

    console.log(answer);
    rl.close();
});
z