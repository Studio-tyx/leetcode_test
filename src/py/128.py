class Solution(object):
    def longestConsecutive(self, nums):
        h = set(nums)
        # for n in nums:
        #     if n not in h:
        #         h[n] = 1
        #     else:
        #         h[n] += 1
        res = 0
        for n in nums:
            temp_num = n
            if temp_num - 1 not in h:
                temp_length = 1
                while temp_num + 1 in h:
                    temp_length += 1
                    temp_num += 1
                if temp_length > res: res = temp_length
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.longestConsecutive(nums = [100,4,200,1,3,2]))
    print(s.longestConsecutive(nums = [0,3,7,2,5,8,4,6,0,1]))
    print(s.longestConsecutive(nums = [0, -1]))