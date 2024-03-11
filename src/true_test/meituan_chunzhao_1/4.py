# 小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积末尾至少有k个 0。小美想知道，一共有多少种不同的删除方案？

import sys

if __name__ == "__main__":
    line = sys.stdin.readline().split()
    n = int(line[0])
    k = int(line[1])
    line = sys.stdin.readline().split()
    a = []
    for i in range(n):
        a.append(int(line[i]))
    left = [1]
    right = [1]
    current = 1
    for i in range(n):
        current = a[i] * current
        left.append(current)
    current = 1
    for i in range(n):
        current = a[n - i - 1] * current
        right.insert(0, current)
    res = 0
    for i in range(n-1):
        for j in range(i+1, n + 1):
            tmp = left[i] * right[j]
            if i < j and tmp % 10**k == 0:
                # print(i, j, left[i], right[j], tmp)

                res += 1
    print(res)
