const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";

const drow = [1, -1, 0, 0];
const dcol = [0, 0, 1, -1];

let [nums, ...arr] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
const [N, L, R] = nums.split(" ").map(Number);
arr = arr.map((row) => row.split(" ").map(Number));

let count = 0;
while (true) {
  const isChecked = Array.from({ length: N }, () => new Array(N).fill(false));
  const unions = [];
  for (let row = 0; row < N; row++) {
    for (let col = 0; col < N; col++) {
      const union = [];
      const que = [];
      que.push([row, col]);
      isChecked[row][col] = true;
      while (que.length > 0) {
        const [currentRow, currentCol] = que.shift();
        for (let dir = 0; dir < 4; dir++) {
          const [nRow, nCol] = [currentRow + drow[dir], currentCol + dcol[dir]];
          if (
            !isCoordValid(nRow, nCol, arr) ||
            isChecked[nRow][nCol] ||
            !isNumValid(arr[currentRow][currentCol], arr[nRow][nCol])
          )
            continue;

          isChecked[nRow][nCol] = true;
          if (union.length === 0) union.push([currentRow, currentCol]);
          union.push([nRow, nCol]);
          que.push([nRow, nCol]);
        }
      }
      if (union.length !== 0) unions.push(union);
    }
  }

  if (unions.length === 0) break;

  for (const union of unions) {
    const size = union.length;
    let sum = 0;
    for (const [row, col] of union) {
      sum += arr[row][col];
    }

    const value = Math.floor(sum / size);
    for (const [row, col] of union) {
      arr[row][col] = value;
    }
  }

  count++;
}

console.log(count);

function isCoordValid(row, col, arr) {
  return 0 <= row && row < arr.length && 0 <= col && col < arr[0].length;
}

function isNumValid(val1, val2) {
  const absNum = Math.abs(val1 - val2);
  return L <= absNum && absNum <= R;
}
