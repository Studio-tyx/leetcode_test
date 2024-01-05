class Solution(object):
    def merge(self, nums1, m, nums2, n):
        new_nums1 = []
        for i in range(m):
            new_nums1.append(nums1[i])
        i = 0
        j = 0
        k = 0
        while (k < len(nums1)):
            if j == n:
                nums1[k] = new_nums1[i]
                i = i + 1
                k = k + 1
                continue
            elif i == m:
                nums1[k] = nums2[j]
                j = j + 1
                k = k + 1
                continue
            elif new_nums1[i] <= nums2[j]:
                nums1[k] = new_nums1[i]
                i = i + 1
            elif new_nums1[i] > nums2[j]:
                nums1[k] = nums2[j]
                j = j + 1
            else:
                print(i, j, m, n)
            k = k + 1
        return nums1



if __name__ == "__main__":
    s = Solution()
    print(s.merge(nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3))
    print(s.merge(nums1 = [0], m = 0, nums2 = [1], n = 1))
    print(s.merge(nums1 = [1], m = 1, nums2 = [], n = 0))