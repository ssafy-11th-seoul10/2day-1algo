const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const line = fs.readFileSync(filePath, "utf-8").trim();

class Stack {
  #arr = [];
  constructor() {}
  push = (num) => {
    this.#arr.push(num);
  };
  pop = () => {
    return this.#arr.pop();
  };
  peek = () => {
    return this.#arr[this.#arr.length - 1];
  };
  isEmpty = () => {
    return this.#arr.length === 0;
  };
  size = () => {
    return this.#arr.length;
  };
}

const main = () => {
  const currentNum = Array.from({ length: line.length }, () => 1);
  let pointer = 0;
  const stk = new Stack();

  let isBeforePopped = false;
  let isValid = true;
  for (const char of line) {
    if (char === "(" || char === "[") {
      if (isBeforePopped) {
        isBeforePopped = false;
        pointer++;
        stk.push([char, true]);
      } else {
        stk.push([char, false]);
      }
    } else {
      if (stk.isEmpty()) {
        isValid = false;
        break;
      } else if (char === ")" && stk.peek()[0] === "(") {
        const [c, m] = stk.pop();
        isBeforePopped = true;
        currentNum[pointer] *= 2;
        if (m) {
          currentNum[pointer - 1] += currentNum[pointer];
          currentNum[pointer] = 1;
          pointer--;
        }
      } else if (char === "]" && stk.peek()[0] === "[") {
        const [c, m] = stk.pop();
        isBeforePopped = true;
        currentNum[pointer] *= 3;
        if (m) {
          currentNum[pointer - 1] += currentNum[pointer];
          currentNum[pointer] = 1;
          pointer--;
        }
      } else {
        isValid = false;
        break;
      }
    }
  }

  let sum = 0;
  for (let i = 0; i < currentNum.length; i++) {
    if (currentNum[i] === 1) break;
    sum += currentNum[i];
  }
  console.log(isValid && stk.size() === 0 ? sum : 0);
};

main();
