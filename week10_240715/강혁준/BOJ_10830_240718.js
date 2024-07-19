const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [nums, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, B] = nums.split(" ").map(Number);
const arr = inputs.map((row) => row.split(" ").map(Number));
const I = Array.from({ length: arr.length }, (_v, i) =>
  Array.from({ length: arr.length }, (_h, j) => (i === j ? 1 : 0))
);
const result = getMatrixPow(B);

result.forEach((x) => console.log(x.join(" ")));

function getMatrixPow(num) {
  if (num === 1) {
    return getMatrixMultiply(arr, I);
  } else if (num % 2 === 0) {
    const result = getMatrixPow(num / 2);
    return getMatrixMultiply(result, result);
  } else {
    count = num - 1;
    const result = getMatrixPow(count / 2);
    return getMatrixMultiply(getMatrixMultiply(result, result), arr);
  }
}

function getMatrixMultiply(mat1, mat2) {
  const matrix = Array.from({ length: mat1.length }, () =>
    new Array(mat1.length).fill(0)
  );

  for (let row = 0; row < mat1.length; row++) {
    for (let col = 0; col < mat1.length; col++) {
      for (let size = 0; size < mat1.length; size++) {
        matrix[row][col] += mat1[row][size] * mat2[size][col];
      }
      matrix[row][col] %= 1000;
    }
  }
  return matrix;
}
