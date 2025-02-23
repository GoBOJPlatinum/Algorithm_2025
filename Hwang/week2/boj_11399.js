const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const n = +input.shift();
const l = input[0].split(' ').map(Number)

l.sort((a,b) => a-b);  //오름차순 정렬

var total = 0;  //시간의 합

for(let i=0; i<n; i++) {
    let sum = l[i];
    for(let j=0; j<i; j++) {
        sum += l[j];
    }
    total += sum;
}

console.log(total);
