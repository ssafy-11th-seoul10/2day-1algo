const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

const main = () => {
  // get input
  const map = Array.from(Array(N), () => Array(N * 2).fill(" "));
  const start = N - 1;
  for (let i = 0; i < map.length; i++) {
    for (let j = 0; j < i * 2 + 1; j++) {
      map[i][start - i + j] = "*";
    }
  }

  // process
  solve(0, 0, N, map);
  print2DArray(map);
};

const solve = (row, col, length, map) => {
  if (length < 3) return;
  else if (length == 3) {
    map[row + 1][col + 2] = " ";
    return;
  } else {
    const sRow = row + length - 1;
    const sCol = col + length - 1;
    for (let i = 0; i < length / 2; i++) {
      for (let j = 0; j < i * 2 + 1; j++) {
        map[sRow - i][sCol - i + j] = " ";
      }
    }
    solve(row, col + length / 2, length / 2, map);
    solve(row + length / 2, col, length / 2, map);
    solve(row + length / 2, col + length, length / 2, map);
  }
};

const print2DArray = (arr) => {
  console.log(arr.map((row) => row.join("")).join("\n"));
};

main();
