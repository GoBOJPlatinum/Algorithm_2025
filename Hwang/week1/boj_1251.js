let input = [];

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

readline.on("line", (line) => {
  input.push(line);
});

readline.on("close", () => {
  solution(input);
  process.exit();
});

const solution = (inp) => {
  let str = inp[0];
  let strlen = str.length;
  let arr = [];
  for (let i = 1; i < strlen - 1; i++) {
    for (let j = i + 1; j < strlen; j++) {
      let word;
      // 0 ~ i-1, i~j-1, j ~ 끝 나누기
      let a = str.slice(0, i);
      let b = str.slice(i, j);
      let c = str.slice(j);

      // 뒤집고 합치기
      let ra = a.split("").reverse().join("");
      let rb = b.split("").reverse().join("");
      let rc = c.split("").reverse().join("");
      
      word = ra + rb + rc;
      arr.push(word);
    }
  }
  arr.sort();
  console.log(arr[0]);
};