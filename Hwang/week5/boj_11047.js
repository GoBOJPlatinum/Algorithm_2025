let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');


let [N, K] = input[0].split(' ').map(Number);


let coins = input.slice(1).map(Number);


coins.sort((a, b) => b - a);

let count = 0;

for (let i = 0; i < N; i++) {
  if (coins[i] <= K) {
    
    let used = Math.floor(K / coins[i]);
    count += used;
    K -= coins[i] * used;
  }
}

console.log(count);
