const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...I] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  const [n, money] = N.split(" ").map(Number);
  const values = I.map(Number);

  const dp = Array.from({ length: money + 1 }, () => 10001);
  dp[0] = 0;

  for (const value of values) {
    for (let i = 1; i <= money; i++) {
      // 만약 value > i라면 continue
      // value <= i라면 dp[i] = Math.min(dp[i-value] + 1, dp[i]);
      if (i >= value) dp[i] = Math.min(dp[i], dp[i - value] + 1);
    }
  }

  console.log(dp[money] !== 10001 ? dp[money] : -1);
};

main();
