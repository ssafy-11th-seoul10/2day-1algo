const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n").map(Number);

class MaxHeap {
  #arr;
  #idx;
  #N;

  constructor(N = 1) {
    this.#arr = [0];
    this.#idx = 1;
    this.#N = N;
  }

  add = (num) => {
    // 가장 마지막 부분에 삽입
    this.#arr[this.#idx] = num;

    // 부모보다 자식이 클 때 위로 올린다
    // 부모보다 자식이 작거나, 부모의 idx가 0일 경우 종료
    let idx = this.#idx;
    while (this.#arr[Math.floor(idx / 2)] <= this.#arr[idx] && Math.floor(idx / 2) !== 0) {
      const tmp = this.#arr[Math.floor(idx / 2)];
      this.#arr[Math.floor(idx / 2)] = this.#arr[idx];
      this.#arr[idx] = tmp;
      idx = Math.floor(idx / 2);
    }
    this.#idx++;

    const maxSize = 2 ** N;
    if (this.#idx > maxSize) {
      this.#arr.length = maxSize;
      this.#idx--;
    }
  };

  poll = () => {
    const output = this.#arr[1];

    // 가장 아래에 있는 노드를 맨 위로 올린다
    // 자식 노드와 값을 비교한다
    // 만약 자식 노드중 현재 노드보다 큰 값이 존재한다면 그 값과 위치를 교체한다
    // 현재 값보다 큰 자식이 없거나, 현재 idx가 this.#idx와 같거나 큰 경우 종료
    this.#arr[1] = this.#arr[this.#idx - 1];
    let idx = 1;
    while (idx < this.#idx) {
      const leftChild = idx * 2;
      const rightChild = idx * 2 + 1;

      if (this.#arr[leftChild] === undefined && this.#arr[rightChild] === undefined) {
        break;
      } else if (this.#arr[leftChild] === undefined || this.#arr[rightChild] === undefined) {
        const validChild = this.#arr[leftChild] === undefined ? rightChild : leftChild;
        if (this.#arr[validChild] > this.#arr[idx]) {
          const tmp = this.#arr[validChild];
          this.#arr[validChild] = this.#arr[idx];
          this.#arr[idx] = tmp;
          idx = validChild;
        } else break;
      } else {
        const maxChild = this.#arr[leftChild] > this.#arr[rightChild] ? leftChild : rightChild;

        if (this.#arr[maxChild] > this.#arr[idx]) {
          const tmp = this.#arr[maxChild];
          this.#arr[maxChild] = this.#arr[idx];
          this.#arr[idx] = tmp;
          idx = maxChild;
        } else break;
      }
    }
    this.#idx--;
    return output;
  };

  peek = () => {
    return this.#arr[1];
  };
}

const main = () => {
  const maxHeap = new MaxHeap();
  let current = inputs[0];
  for (let i = 1; i < N; i++) {
    maxHeap.add(inputs[i]);
  }

  let count = 0;
  while (maxHeap.peek() >= current) {
    let top = maxHeap.poll();
    top--;
    current++;
    count++;
    maxHeap.add(top);
  }

  console.log(count);
};

main();
