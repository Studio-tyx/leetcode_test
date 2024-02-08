class Solution(object):
    def maxAreaBF(self, height):
        res = 0
        n = len(height)
        for i in range(n):
            for j in range(i, n):
                res = max(res, min(height[i], height[j])*(j - i))

        return res

    def maxArea(self, height):
        n = len(height)
        a = 0
        b = n - 1
        res = 0
        while(a != n and b != -1):
            if height[a] >= height[b]:
                res = max(res, height[b] * abs(a - b))
                b = b - 1
            else:
                res = max(res, height[a] * abs(a - b))
                a = a + 1
        return res 
    

if __name__ == "__main__":
    s = Solution()
    print(s.maxArea([1,8,6,2,5,4,8,3,7]))
    print(s.maxArea([1,1]))