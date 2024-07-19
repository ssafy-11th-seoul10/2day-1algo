const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [nums, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = nums.split(" ").map(Number);
const arr = inputs.map(Number).sort((e1, e2) => e1 - e2);

let left = 0;
let right = arr[arr.length - 1] - arr[0];
let output = 0;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);
  if (solve(mid, M, arr)) {
    output = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(output);

function solve(minLength, minCount, arr) {
  let count = 1;
  let before = arr[0];

  for (const item of arr) {
    if (item - before >= minLength) {
      count++;
      before = item;
    }
  }

  return count >= minCount;
}
