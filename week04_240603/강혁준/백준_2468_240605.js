class Node {
  row;
  col;
  constructor(row, col) {
    this.row = row;
    this.col = col;
  }
}

const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("\n");

// get input
const N = parseInt(inputs[0]);
let map = new Array(N);
for (let i = 0; i < N; i++) {
  map[i] = new Array(N);
}
for (let i = 1; i < inputs.length; i++) {
  const words = inputs[i].split(" ");
  for (let j = 0; j < words.length; j++) {
    map[i - 1][j] = parseInt(words[j]);
  }
}

// process
const drow = [1, -1, 0, 0];
const dcol = [0, 0, 1, -1];
let maxCount = 0;
for (let height = 0; height <= 100; height++) {
  let copiedMap = map.map((r) => [...r]);
  const que = new Array();
  let count = 0;

  // BFS
  for (let row = 0; row < N; row++) {
    for (let col = 0; col < N; col++) {
      if (copiedMap[row][col] > height) {
        count++;
        copiedMap[row][col] = -1;
        que.push(new Node(row, col));
        while (que.length > 0) {
          const current = que.shift();
          for (let dir = 0; dir < 4; dir++) {
            const nRow = current.row + drow[dir];
            const nCol = current.col + dcol[dir];
            if (0 <= nRow && nRow < N && 0 <= nCol && nCol < N && copiedMap[nRow][nCol] > height) {
              copiedMap[nRow][nCol] = -1;
              que.push(new Node(nRow, nCol));
            }
          }
        }
      }
    }
  }

  if (count === 0) break;
  maxCount = Math.max(maxCount, count);
}

// output
console.log(maxCount);
