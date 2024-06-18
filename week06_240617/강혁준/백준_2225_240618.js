const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, K] = fs.readFileSync(filePath, "utf-8").trim().split(" ");

const MOD = 1_000_000_000;
let dp;

const main = () => {
  // get input
  const [n, k] = [+N, +K];

  // process
  dp = Array.from({ length: n + 1 }, () => new Array(k + 1).fill(0));
  const output = solve(n, k);

  console.log(output);
};

const solve = (n, k) => {
  if (n === 0 || k === 1) return 1;
  if (dp[n][k] !== 0) return dp[n][k];

  let output = 0;
  for (let i = 0; i <= n; i++) {
    output = (output + solve(i, k - 1)) % MOD;
  }
  dp[n][k] = output;
  return dp[n][k];
};

main();
