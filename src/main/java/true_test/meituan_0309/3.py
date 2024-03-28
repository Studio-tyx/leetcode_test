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


def test_current():
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


def io():
    line = sys.stdin.readline()
    tmp = line.split()
    n = int(tmp[0])
    a = []
    for i in range(n):
        tmp = list(sys.stdin.readline())[:-1]
        a.append(tmp)
    return n, a    


def fupan(n, a):
    sum_matrix = []
    sum_matrix.append([0]*(n+1))
    for i in range(1, n+1):
        line = [0]
        for j in range(1, n+1):
            line.append(sum_matrix[i-1][j]+line[j-1]+int(a[i-1][j-1])-sum_matrix[i-1][j-1])
        sum_matrix.append(line)
    for jie in range(1, n+1):
        if jie % 2 == 1:
            print(0)
        else:
            count = 0
            for i in range(jie, n+1):
                for j in range(jie, n+1):
                    value = sum_matrix[i][j]+sum_matrix[i-jie][j-jie]-sum_matrix[i][j-jie]-sum_matrix[i-jie][j]
                    if value == jie*jie/2:
                        count+=1
            print(count)


if __name__ == "__main__":
    # fupan(4,[['1','0','1','0'],['0','1','0','1'],['1','1','0','0'],['0','0','1','1']])
    n, a = io()
    fupan(n,a)
