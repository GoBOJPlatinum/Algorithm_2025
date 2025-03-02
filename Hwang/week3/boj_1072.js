const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on("line", function (line) {
    let [X, Y] = line.split(" ").map(Number);
    let Z = Math.floor((Y * 100) / X); // 현재 승률

    if (Z >= 99) {
        console.log(-1); // 99% 이상이면 더 이상 승률을 올릴 수 없음
        rl.close();
        return;
    }

    let left = 0, right = 1000000000, answer = -1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let newZ = Math.floor(((Y + mid) * 100) / (X + mid)); // 새로운 승률 계산

        if (newZ > Z) { 
            answer = mid;
            right = mid - 1; // 더 적은 경기 수를 찾기 위해 범위를 줄임
        } else {
            left = mid + 1; // 승률이 오르지 않으면 mid 값을 늘려야 함
        }
    }

    console.log(answer);
    rl.close();
});
