const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, input] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  // get input
  const n = +N;
  const inputs = input.split(" ").map(Number);
  const sum = new Array(inputs.length).fill(0);

  // process
  // 자기 자신을 포함하는 가장 큰 합
  let output = 0;
  for (let i = inputs.length - 1; i >= 0; i--) {
    let tmpSum = 0;
    for (let j = i + 1; j < inputs.length; j++) {
      if (inputs[i] < inputs[j]) tmpSum = Math.max(tmpSum, sum[j]);
    }
    sum[i] = tmpSum + inputs[i];
    output = Math.max(output, sum[i]);
  }

  // output
  console.log(output);
};

main();
