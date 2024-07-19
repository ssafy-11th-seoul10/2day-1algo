const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const n = +N;

class Node {
  value;
  child;

  constructor(value) {
    this.value = value;
    this.child = [];
  }

  addChild = ([value, cost]) => {
    this.child.push([value, cost]);
  };
}

const nodes = Array.from({ length: n + 1 }, (_, idx) => new Node(idx + 1));

for (const input of inputs) {
  const [parent, child, cost] = input.split(" ").map(Number);
  nodes[parent].addChild([child, cost]);
}

let max = 0;
getMax(1);
console.log(max);

// 부모 노드에서 바로 아래 자식 노드들의 최댓값 두개를 구한다
// 두개를 더한 값을 max에 갱신한다
// 가장 큰 노드의 값을 return 한다
function getMax(parent) {
  let firstMax = 0;
  let secondMax = 0;
  for (const [idx, cost] of nodes[parent].child) {
    let currentValue;
    // leaf node라면
    if (nodes[idx].child.length === 0) {
      currentValue = cost;
    } else {
      currentValue = cost + getMax(idx);
    }

    if (currentValue >= firstMax) {
      secondMax = firstMax;
      firstMax = currentValue;
    } else if (currentValue > secondMax) {
      secondMax = currentValue;
    }
  }

  max = Math.max(max, firstMax + secondMax);
  return firstMax;
}
