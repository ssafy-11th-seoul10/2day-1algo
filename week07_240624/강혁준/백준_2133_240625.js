const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

const main = () => {
  if (N % 2 === 1) console.log(0);
  else {
    const dp = [3];
    for (let i = 1; i <= N / 2; i++) {
      let start = dp[i - 1] * 3;
      for (let j = i - 2; j >= 0; j--) {
        start += dp[j] * 2;
      }
      dp[i] = start + 2;
    }
    console.log(dp[N / 2 - 1]);
  }
};

main();
