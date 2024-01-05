class Solution(object):
    def removeElement(self, nums, val):
        new_nums = []
        for i in nums:
            new_nums.append(i)
        for i in new_nums:
            if i == val:
                nums.remove(i)
        return len(nums)
        # return nums


if __name__ == "__main__":
    s = Solution()
    print(s.removeElement(nums = [3,2,2,3], val = 3))
    print(s.removeElement(nums = [0,1,2,2,3,0,4,2], val = 2))