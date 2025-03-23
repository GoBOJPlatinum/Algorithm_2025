let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let [N, M] = input[0].split(' ').map(Number);

let setPrices = [];
let singlePrices = [];

for (let i = 1; i <= M; i++) {
  let [setPrice, singlePrice] = input[i].split(' ').map(Number);
  setPrices.push(setPrice);
  singlePrices.push(singlePrice);
}

let minSet = Math.min(...setPrices);
let minSingle = Math.min(...singlePrices);

let option1 = Math.ceil(N / 6) * minSet;

let option2 = Math.floor(N / 6) * minSet + (N % 6) * minSingle;

let option3 = N * minSingle;


console.log(Math.min(option1, option2, option3));
