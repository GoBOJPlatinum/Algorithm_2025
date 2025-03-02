let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let n = Number(input[0]);
let origin = input[1].split(' ').map(Number);

let sorted = [...new Set(origin)].sort((a, b) => a - b);
let sortedObj = {};
for (let i=0; i<sorted.length; i++) {
  sortedObj[sorted[i]] = i;
}

let answer = "";
for (let i=0; i<n; i++) {
  answer += sortedObj[origin[i]] + " ";
}
console.log(answer)