class Solution(object):
    def merge(self, intervals):
        intervals.sort(key=lambda x: x[0])
        if len(intervals) == 0: return []
        min_start = intervals[0][0]
        max_end = intervals[0][1]
        res = []
        for interval in intervals:
            if interval[0] == min_start:
                max_end = max(interval[1], max_end)
            elif min_start < interval[0] <= max_end:
                max_end = max(interval[1], max_end)
            else:
                res.append([min_start, max_end])
                min_start = interval[0]
                max_end = interval[1]
        if len(res) == 0 or min_start != res[-1][0]:
            res.append([min_start, max_end])
        return res



if __name__ == "__main__":
    s = Solution()
    print(s.merge([[1,3],[2,6],[8,10],[15,18]]))
    print(s.merge([[1,4],[4,5]]))