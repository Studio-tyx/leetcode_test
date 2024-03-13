class Solution(object):
    def findMinArrowShots(self, points):
        points.sort(key = lambda x:(x[0], x[1]))
        print(points)
        res = []
        res.append(points[0])
        for i in range(len(points)):
            if points[i][0] <= res[-1][1]:
                res[-1][0] = points[i][0]
                if points[i][1] <= res[-1][1]:
                    res[-1][1] = points[i][1]
            else:
                res.append(points[i])
        print(points)
        print(res)
        return len(res)


if __name__ == "__main__":
    s = Solution()
    print(s.findMinArrowShots([[10,16],[2,8],[1,6],[7,12]]))
    print(s.findMinArrowShots([[1,2],[3,4],[5,6],[7,8]]))
    print(s.findMinArrowShots([[1,2],[2,3],[3,4],[4,5]]))
    print(s.findMinArrowShots([[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]))
    print(s.findMinArrowShots([[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]))