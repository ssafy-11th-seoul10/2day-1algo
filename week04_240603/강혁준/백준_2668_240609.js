const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...nums] = fs.readFileSync(filePath, "utf-8").trim().split("\n").map(Number);
nums.unshift(undefined);

const main = () => {
  const output = [];
  for (let i = 1; i <= N; i++) {
    const result = dfs(i, nums[i], 0);
    if (result) {
      output.push(i);
    }
  }

  console.log([output.length, ...output].join("\n"));
};

const dfs = (start, value, count) => {
  if (start === value) return true;
  else if (count >= N) return false;
  else {
    const result = dfs(start, nums[value], count + 1);
    if (result) return true;
    else return false;
  }
};

main();
