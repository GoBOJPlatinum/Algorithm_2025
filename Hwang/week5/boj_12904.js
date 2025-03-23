let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');


let S = input[0];
let T = input[1];


while (T.length > S.length) {
  if (T[T.length - 1] === 'A') {
    T = T.slice(0, -1);

  } else if (T[T.length - 1] === 'B') {
    T = T.slice(0, -1).split('').reverse().join('');
  }
}


console.log(S === T ? 1 : 0);
