const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

const output = [];
let tmp = [];

const main = () => {
  solve(0, M);
  console.log(output.join("\n"));
};

const solve = (depth, max) => {
  if (depth === max) {
    output.push(tmp.join(" "));
  } else {
    for (let i = 1; i <= N; i++) {
      tmp[depth] = i;
      solve(depth + 1, max);
    }
  }
};

main();
