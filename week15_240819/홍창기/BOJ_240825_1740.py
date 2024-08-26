n = int(input())
p3 = 1
li = []

while n > 0:
    if n & 1:
        li.append(p3)

    n >>= 1
    p3 *= 3

print(sum(li))
