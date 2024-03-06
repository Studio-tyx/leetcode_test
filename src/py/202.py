class Solution(object):
    def isHappy(self, n):
        sum = n
        res = {}
        while sum != 1:
            nums = str(n)
            sum = 0
            for i in range(len(nums)):
                sum += int(nums[i]) ** 2
            if sum not in res:
                res[sum] = 0
            else:
                return False
            n = sum
        return True


if __name__ == "__main__":
    s = Solution()
    print(s.isHappy(68))
    print(s.isHappy(128))
    print(s.isHappy(86))
    print(s.isHappy(2))
