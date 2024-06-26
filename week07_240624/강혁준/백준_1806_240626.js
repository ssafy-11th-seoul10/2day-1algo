const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const lines = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  const [N, M] = lines[0].split(" ").map(Number);
  const arr = lines[1].split(" ").map(Number);
  const accArr = [0];
  arr.map((value, i) => {
    accArr[i + 1] = accArr[i] + value;
  });

  let left = 1;
  let right = accArr.length;
  let output = 0;
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    if (solve(accArr, mid, M)) {
      output = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  console.log(output);
};

const solve = (accArr, size, M) => {
  for (let i = size; i < accArr.length; i++) {
    if (accArr[i] - accArr[i - size] >= M) return true;
  }
  return false;
};

main();
