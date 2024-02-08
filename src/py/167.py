class Solution(object):
    def twoSum(self, numbers, target):
        a = 0
        b = len(numbers) - 1
        while(a != len(numbers) or b != -1):
            if numbers[a] + numbers[b] == target:
                return [a + 1, b + 1]
            elif numbers[a] + numbers[b] > target:
                b = b - 1
            else:
                a = a + 1


if __name__ == "__main__":
    s = Solution()
    print(s.twoSum(numbers = [2,7,11,15], target = 9))
    print(s.twoSum(numbers = [2,3,4], target = 6))
    print(s.twoSum(numbers = [-1,0], target = -1))