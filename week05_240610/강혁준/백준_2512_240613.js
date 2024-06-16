const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, requires, M] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  // get input
  const [n, require, m] = [+N, requires.split(" ").map(Number), +M];

  // process
  const sum = require.reduce((acc, cur) => {
    return acc + cur;
  }, 0);
  const arrMax = Math.max(...require);

  if (sum <= m) {
    console.log(arrMax);
  } else {
    // 이분탐색
    let left = 0;
    let right = arrMax;
    let max = -1;
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);

      if (solve(require, m, mid)) {
        max = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    console.log(max);
  }
};

const solve = (arr, max, threshold) => {
  let sum = 0;
  for (const value of arr) {
    if (threshold >= value) sum += value;
    else sum += threshold;
  }

  if (sum <= max) return true;
  else return false;
};

main();
