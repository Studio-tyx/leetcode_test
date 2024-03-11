# 小美拿到了一个n*n的矩阵，其中每个元素是 0 或者 1。
# 小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
# 现在，小美希望你回答有多少个i*i的完美矩形区域。你需要回答1\leq i \leq n的所有答案。

import sys

def count(a, i, n):
    res = 0
    for j in range(n-i+1):
        for k in range(n-i+1):
            count_1 = 0
            for j_i in range(j, j + i):
                for k_i in range(k, k + i):
                    if a[j_i][k_i] == '1':
                        count_1 += 1
            if count_1 == i * i / 2:
                res += 1
    return res        


if __name__ == "__main__":
    line = sys.stdin.readline()
    tmp = line.split()
    n = int(tmp[0])
    a = []
    for i in range(n):
        tmp = list(sys.stdin.readline())[:-1]
        a.append(tmp)
    for i in range(1, n+1):
        if i % 2 == 1:
            print(0)
        else:
            print(count(a, i, n))