import sys

input = lambda : sys.stdin.readline().rstrip()
ans = [1, 1, 3]

for i in range(3, 251):
    ans.append(ans[-2] * 2 + ans[-1])

while x := input():
    print(ans[int(x)])
