while (n := int(input())) != 0:
    if n == 1:
        print("{ }")
        continue

    n -= 1
    p3 = 1
    li = []

    while n > 0:
        if n & 1:
            li.append(p3)

        n >>= 1
        p3 *= 3

    print("{ %s }" % ", ".join(map(str, li)))
