const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = "";

rl.on("line", (line) => {
  input = line;
}).on("close", () => {
  
  //순서
  const croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];

  let count = 0;

  croatia.forEach((pattern) => {
    const matches = input.match(new RegExp(pattern, "g"));
    if (matches) {
      count += matches.length;
      input = input.replace(new RegExp(pattern, "g"), " ");
    }
  });
  // 나머지 원래 알파벳 개수 더하기
  const remainder = input.replace(/ /g, "").length;

  console.log(count + remainder);
  process.exit();
});
