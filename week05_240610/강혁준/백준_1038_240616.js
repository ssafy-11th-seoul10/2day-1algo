const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = fs.readFileSync(filePath, "utf-8").trim();

const main = () => {
  // get input
  const n = +N;

  // process
  const savedNum = [];

  for (let size = 1; size <= 10; size++) {
    const tmpSave = [];
    solve(10, 0, size, tmpSave, savedNum);
  }

  // output
  console.log(n >= savedNum.length ? -1 : savedNum[n]);
};

const solve = (befMax, currentDepth, maxSize, tmpSave, savedNum) => {
  if (currentDepth === maxSize) {
    let num = 0;
    for (let i = 0; i < tmpSave.length; i++) {
      const element = tmpSave[i];
      num += element * 10 ** (tmpSave.length - i - 1);
    }
    savedNum.push(num);
  } else {
    for (let num = 0; num < befMax; num++) {
      tmpSave[currentDepth] = num;
      solve(num, currentDepth + 1, maxSize, tmpSave, savedNum);
    }
  }
};

main();
