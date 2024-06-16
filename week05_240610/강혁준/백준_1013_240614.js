const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...lines] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  let output = [];
  for (const line of lines) {
    // process
    const isOkay = solve(line);
    output.push(isOkay ? "YES" : "NO");
  }

  // output
  console.log(output.join("\n"));
};

const solve = (line) => {
  let start = 0;
  let last = 0;
  while (last < line.length) {
    // start가 1일 때 1001 패턴인지 확인한다
    if (line[start] === "1") {
      last++;

      // start가 1일 때 그 다음 0의 갯수를 센다
      let zeroCount = 0;
      while (last < line.length && line[last] === "0") {
        last++;
        zeroCount++;
      }

      // 만약 1 다음에 오는 0의 갯수가 2보다 작으면 유효한 패턴이 아니다
      if (last === line.length || zeroCount < 2) return false;

      // 0 다음 오는 1의 갯수를 센다
      let oneCount = 0;
      while (last < line.length && line[last] === "1") {
        last++;
        oneCount++;
      }

      // 1의 갯수가 0개 이하면 유효한 패턴이 아니다
      if (oneCount <= 0) return false;

      // last가 문자열의 마지막까지 오면 패턴이 종료되었다
      if (last === line.length) return true;

      // 0 다음 오는 1의 갯수가 1개이면 다음 01 패턴을 확인한다
      if (oneCount === 1) start = last;
        
      // 0 다음 오는 1의 갯수가 2개 이상이면 그 다음 패턴이 1001 패턴인지 01 패턴인지 확인해야 한다
      else {
        // 01 패턴일 경우
        if (line.length > last + 1 && line[last + 1] == "1") {
          last += 2;
          start = last;
        }
        // 1001 패턴일 경우
        else {
          last--;
          start = last;
        }
      }
    }

    // start가 0일 때 01 패턴인지 확인한다
    else {
      last++;
      if (line[last] === "1") {
        last++;
        start = last;
      } else {
        return false;
      }
    }
  }
  return true;
};

main();
