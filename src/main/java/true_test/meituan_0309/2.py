# 小美拿到了一个由正整数组成的数组，但其中有一些元素是未知的（用 0 来表示）。
# 现在小美想知道，如果那些未知的元素在区间[l,r]范围内随机取值的话，数组所有元素之和的最小值和最大值分别是多少？
# 共有q次询问。
import sys
if __name__ == "__main__":
    line = sys.stdin.readline()
    tmp = line.split()
    n = int(tmp[0])
    q = int(tmp[1])
    line = sys.stdin.readline()
    a = line.split()
    tmp_sum = 0
    tmp_count = 0
    for i in range(n):
        tmp_sum += int(a[i])
        if int(a[i]) == 0:
            tmp_count += 1
    for i in range(q):
        line = sys.stdin.readline().split()
        down = tmp_sum + tmp_count * int(line[0])
        up = tmp_sum + tmp_count * int(line[1])
        print(down, up)