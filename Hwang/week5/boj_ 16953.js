const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
let [A, B] = input.map(Number);

let count = 1;

while (B > A) {
  if (B % 10 === 1) {
    B = Math.floor(B / 10);
  } else if (B % 2 === 0) {
    B = B / 2;
  } else {
    break;
  }
  count++;
}

console.log(B === A ? count : -1);
