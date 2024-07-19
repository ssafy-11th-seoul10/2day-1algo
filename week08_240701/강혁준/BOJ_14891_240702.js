const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [a, b, c, d, N, ...inputs] = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n");

const n = +N;
class Gear {
  arr;
  left;
  right;
  idx;

  constructor(arr) {
    this.arr = arr;
    this.idx = 0;
    this.setLeftAndRight();
  }

  setLeftAndRight() {
    // 0 1 2 3 4 5 6 7
    this.right = this.arr[(this.idx + 2) % 8];
    this.left = this.arr[(this.idx + 6) % 8];
  }

  turnLeft() {
    this.idx = (this.idx + 1) % 8;
    this.setLeftAndRight();
  }

  turnRight() {
    this.idx = (this.idx + 7) % 8;
    this.setLeftAndRight();
  }

  isTopS() {
    return this.arr[this.idx] === "1";
  }
}

const gears = [];
gears[1] = new Gear(a);
gears[2] = new Gear(b);
gears[3] = new Gear(c);
gears[4] = new Gear(d);

for (let TC = 0; TC < n; TC++) {
  const [no, direction] = inputs[TC].split(" ").map(Number);
  const isTurn = Array.from({ length: 5 }, () => [false, 0]);
  isTurn[no] = [true, direction];

  let currentDirecton = direction;
  for (let j = no; j < 4; j++) {
    if (gears[j].right !== gears[j + 1].left) {
      isTurn[j + 1] = [true, currentDirecton * -1];
      currentDirecton *= -1;
    } else break;
  }

  currentDirecton = direction;
  for (let j = no; j > 1; j--) {
    if (gears[j].left !== gears[j - 1].right) {
      isTurn[j - 1] = [true, currentDirecton * -1];
      currentDirecton *= -1;
    } else break;
  }

  for (let j = 1; j <= 4; j++) {
    const [isRotate, dir] = isTurn[j];
    if (!isRotate) continue;
    if (dir === 1) gears[j].turnRight();
    else gears[j].turnLeft();
  }
}

let sum = 0;
for (let i = 1; i <= 4; i++) {
  if (gears[i].isTopS()) {
    sum += 2 ** (i - 1);
  }
}
console.log(sum);
