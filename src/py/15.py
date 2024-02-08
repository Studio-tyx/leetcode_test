class Solution(object):
    def threeSum(self, nums):
        res = []
        nums = sorted(nums)
        former = []
        for i in range(len(nums)):
            tmp = self.find_sum(nums[i+1:], -nums[i])
            if former == tmp: continue
            for bc in tmp:
                if [nums[i], bc[0], bc[1]] not in res:
                    res.append([nums[i], bc[0], bc[1]])
            former = tmp
        return res
            
    def find_sum(self, numbers, target):
        a = 0
        b = len(numbers) - 1
        res = []
        while(a != len(numbers) and b != -1 and a != b):
            if numbers[a] + numbers[b] == target:
                res.append([numbers[a], numbers[b]])
                if b - a == 1: break
                a = a + 1
                b = b - 1
            elif numbers[a] + numbers[b] > target:
                b = b - 1
            else:
                a = a + 1
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.threeSum([-1,0,1,2,-1,-4]))
    print(s.threeSum([-2,0,1,1,2]))
    print(s.threeSum([0,0,0]))
    print(s.threeSum([0,0,0,0]))