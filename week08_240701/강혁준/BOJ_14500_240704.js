const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [S, ...map] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const isValid = (row, col, map) => {
  return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
};

const [R, C] = S.split(" ").map(Number);
map.forEach((line, idx) => (map[idx] = line.split(" ").map(Number)));

const objects = [];

// -
objects[0] = {
  drow: [0, 0, 0, 0],
  dcol: [0, 1, 2, 3],
};
objects[1] = {
  drow: [0, -1, -2, -3],
  dcol: [0, 0, 0, 0],
};

// ㅁ
objects[2] = {
  drow: [0, 0, -1, -1],
  dcol: [0, 1, 0, 1],
};

// L
objects[3] = {
  drow: [0, 0, -1, -2],
  dcol: [0, 1, 0, 0],
};
objects[4] = {
  drow: [0, 0, 0, -1],
  dcol: [0, 1, 2, 2],
};
objects[5] = {
  drow: [-2, -2, -1, 0],
  dcol: [0, 1, 1, 1],
};
objects[6] = {
  drow: [0, -1, -1, -1],
  dcol: [0, 0, 1, 2],
};
objects[7] = {
  drow: [0, 0, -1, -2],
  dcol: [0, 1, 1, 1],
};
objects[8] = {
  drow: [0, 0, 0, -1],
  dcol: [0, 1, 2, 0],
};
objects[9] = {
  drow: [0, -1, -2, -2],
  dcol: [0, 0, 0, 1],
};
objects[10] = {
  drow: [-1, -1, -1, 0],
  dcol: [0, 1, 2, 2],
};

// -L
objects[11] = {
  drow: [-2, -1, -1, 0],
  dcol: [0, 0, 1, 1],
};
objects[12] = {
  drow: [0, 0, -1, -1],
  dcol: [0, 1, 1, 2],
};
objects[13] = {
  drow: [0, -1, -1, -2],
  dcol: [0, 0, 1, 1],
};
objects[14] = {
  drow: [-1, -1, 0, 0],
  dcol: [0, 1, 1, 2],
};

// ㅗ
objects[15] = {
  drow: [-1, -1, -1, 0],
  dcol: [0, 1, 2, 1],
};
objects[16] = {
  drow: [0, -1, -2, -1],
  dcol: [0, 0, 0, 1],
};
objects[17] = {
  drow: [0, 0, 0, -1],
  dcol: [0, 1, 2, 1],
};
objects[18] = {
  drow: [0, -1, -2, -1],
  dcol: [1, 1, 1, 0],
};

let max = 0;
for (let row = 0; row < R; row++) {
  for (let col = 0; col < C; col++) {
    for (const object of objects) {
      const { drow, dcol } = object;
      let flag = true;
      let sum = 0;
      for (let dir = 0; dir < 4; dir++) {
        const nRow = row + drow[dir];
        const nCol = col + dcol[dir];
        if (isValid(nRow, nCol, map)) {
          sum += map[nRow][nCol];
        } else {
          flag = false;
          break;
        }
      }
      if (!flag) continue;
      max = Math.max(max, sum);
    }
  }
}

console.log(max);
