# 小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积末尾至少有k个 0。小美想知道，一共有多少种不同的删除方案？

# 知道分解2和5的数量之后可以减少很多的超时（我之前真的就摁算来着）
# 其实复盘还是在超时，我也不知道为什么了，可能和python也有关系吧
import sys

def test_current():
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

def fupan(n, k, a):
    two = [0]
    five = [0]
    for aa in a:
        tmp = aa
        count = 0
        while tmp % 2 == 0:
            count += 1
            tmp /= 2
        two.append(two[-1] + count)
        tmp = aa
        count = 0
        while tmp % 5 == 0:
            count += 1
            tmp /= 5
        five.append(five[-1] + count)  
    res = 0
    for i in range(n+1):
        for j in range(i+1, n+1):
            space2 = two[j] - two[i]
            space5 = five[j] - five[i]
            remain2 = two[n] - space2
            remain5 = five[n] - space5
            if min(remain2, remain5) < k:
                break
            else:
                res += 1
        # res += (j-i)
    print(res)

def io():
    line = sys.stdin.readline().split()
    n = int(line[0])
    k = int(line[1])
    line = sys.stdin.readline().split()
    a = []
    for i in range(n):
        a.append(int(line[i]))
    return a 

if __name__ == "__main__":
    # test_current()
    # fupan(io())
    fupan(9,1,[2,5,3,7,8,5,10,9,5])
    # fupan(5,2,[2,5,3,4,20])
    # l = [1,2,3,4]
    # print(l[0:], l[:0])