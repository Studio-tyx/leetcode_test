class Solution(object):
    def insert(self, intervals, newInterval):
        index = 0
        res = []
        start = newInterval[0]
        end = newInterval[1]
        if len(intervals) == 0:
            return [newInterval]
        while index < len(intervals) and intervals[index][1] < newInterval[0]:
            start = intervals[index][0]
            index += 1
        if index == len(intervals): 
            intervals.append(newInterval)
            return intervals
        res.extend(intervals[:index])
        start = min(intervals[index][0], newInterval[0])
        while index < len(intervals) and intervals[index][0] <= newInterval[1]:
            end = intervals[index][1]
            index += 1
        if index == len(intervals): 
            res.append([start, max(end, newInterval[1])])
            return res
        end = max(end, newInterval[1])
        res.append([start, end])
        res.extend(intervals[index:])
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.insert(intervals = [[1,3],[6,9]], newInterval = [2,5]))
    print(s.insert(intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]))
    print(s.insert(intervals = [], newInterval = [5,7]))
    print(s.insert(intervals = [[1,5]], newInterval = [2,3]))
    print(s.insert(intervals = [[1,5]], newInterval = [2,7]))
    print(s.insert([[1,2],[3,5]], [3,6]))
    print(s.insert(intervals = [[1,5]], newInterval = [5,7]))
    print(s.insert([[1,5]], [0,0]))