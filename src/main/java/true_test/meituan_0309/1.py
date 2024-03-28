# MT 是美团的缩写，因此小美很喜欢这两个字母。
# 现在小美拿到了一个仅由大写字母组成字符串，她可以最多操作k次，每次可以修改任意一个字符。小美想知道，操作结束后最多共有多少个'M'和'T'字符？

import sys

# for line in sys.stdin:
#     a = line.split()
#     print(int(a[0]) + int(a[1]))

# line = sys.stdin.readline()
# a = line.split()
# print(int(a[0]) + int(a[1]))


line = sys.stdin.readline()
tmp = line.split()
n = int(tmp[0])
k = int(tmp[1])

res = 0
line = sys.stdin.readline()
for s in line:
    if s == 'M' or s == 'T':
        res += 1
res += k
res = min(n, res)
print(res)