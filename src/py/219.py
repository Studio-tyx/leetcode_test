class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        h = {}
        for i in range(len(nums)):
            if nums[i] not in h:
                h[nums[i]] = i
            else:
                if i - h[nums[i]] <= k:
                    return True
                else:
                    h[nums[i]] = i
        return False
    

if __name__ == "__main__":
    s = Solution()
    print(s.containsNearbyDuplicate(nums = [1,2,3,1], k = 3))
    print(s.containsNearbyDuplicate(nums = [1,0,1,1], k = 1))
    print(s.containsNearbyDuplicate(nums = [1,2,3,1,2,3], k = 2))