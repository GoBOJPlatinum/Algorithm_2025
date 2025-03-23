const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on("line", function (line) {
    input.push(line);
}).on("close", function () {
    const [N, M] = input[0].split(" ").map(Number);
    let titles = [];
    let powers = [];
    
    // 칭호와 기준 전투력 저장
    for (let i = 1; i <= N; i++) {
        let [title, power] = input[i].split(" ");
        titles.push(title);
        powers.push(Number(power));
    }

    let result = [];
    
    const binarySearch = (val) => {
        let left = 0, right = N - 1;
        while (left < right) {
            let mid = Math.floor((left + right) / 2);
            if (powers[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return titles[left]; // 가장 먼저 val 이상이 되는 칭호 반환
    };

    // M개의 전투력에 대해 칭호 찾기
    for (let j = N + 1; j < N + M + 1; j++) {
        let power = Number(input[j]);
        result.push(binarySearch(power));
    }

    console.log(result.join("\n"));
    process.exit();
});
