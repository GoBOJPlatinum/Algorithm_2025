const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on("line", function (line) {
    input.push(line);
}).on("close", function () {
    const [N, atk] = input[0].split(" ").map(Number);
    const rooms = input.slice(1).map(line => line.split(" ").map(Number));

    let left = 1;
    let right = 1e18;
    let answer = right;

    // 던전을 클리어할 수 있는지 확인하는 함수
    function canClearDungeon(maxHP) {
        let curHP = maxHP;
        let curAtk = atk;

        for (const [t, a, h] of rooms) {
            if (t === 1) { // 몬스터 방
                let playerHits = Math.ceil(h / curAtk);
                let monsterHits = Math.ceil(curHP / a);

                if (playerHits > monsterHits) return false; // 플레이어가 죽음
                curHP -= (playerHits - 1) * a; // 플레이어 체력 감소
            } else { // 포션 방
                curAtk += a;
                curHP = Math.min(maxHP, curHP + h);
            }
        }
        return true;
    }

    // 이진 탐색
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);

        if (canClearDungeon(mid)) {
            answer = mid;
            right = mid - 1; // 더 작은 최대 체력을 찾음
        } else {
            left = mid + 1; // 더 큰 체력이 필요
        }
    }

    console.log(answer);
    rl.close();
});
