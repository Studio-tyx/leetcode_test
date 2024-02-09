class Solution(object):
    def minSubArrayLen(self, target, nums):
        tmp = 0
        a = 0
        b = 0
        min_len = len(nums) + 1
        while(True):
            if tmp >= target and a != len(nums):
                min_len = min(min_len, b-a)
                tmp -= nums[a]
                a += 1
                continue
            elif tmp < target and b != len(nums):
                tmp += nums[b]
                b += 1
                continue
            if a == len(nums): break
            if b == len(nums):
                a += 1
        if min_len == len(nums) + 1: return 0
        else: return min_len


if __name__ == "__main__":
    s = Solution()
    print(s.minSubArrayLen(target = 7, nums = [2,3,1,2,4,3]))
    print(s.minSubArrayLen(target = 4, nums = [1,4,4]))
    print(s.minSubArrayLen(target = 15, nums = [1,2,3,4,5]))
    print(s.minSubArrayLen(target = 11, nums = [1,2,3,4,5]))
    print(s.minSubArrayLen(target = 5, nums = [1,2,3,4,5]))
    print(s.minSubArrayLen(target = 11, nums = [1,1,1,1,1,1,1,1]))