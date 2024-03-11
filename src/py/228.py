class Solution(object):
    def summaryRanges(self, nums):
        if len(nums) == 0: return []
        start = nums[0]
        now = nums[0]
        res = []
        former_str = str(nums[0])
        for i in nums[1:]:
            if i != now + 1:
                if now != start:
                    former_str += "->" + str(now)
                res.append(former_str)
                start = i
                former_str = str(start)
            now = i
        if now != start:
            former_str += '->' + str(now)
        res.append(former_str)
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.summaryRanges([0,1,2,4,5,7]))
    print(s.summaryRanges([0,2,3,4,6,8,9]))