class Solution(object):
    def spiralOrder(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        flag = []
        for i in range(m):
            temp = []
            for j in range(n):
                temp.append(0)
            flag.append(temp)
        direct = 1
        end = 0
        i = 0
        j = -1
        res = []
        while end < 4:
            if direct == 1:
                if j + 1 < n and flag[i][j + 1] == 0:
                    j += 1
                    res.append(matrix[i][j])
                    flag[i][j] = 1
                    end = 0
                else:
                    direct = 2
                    end += 1
            elif direct == 2:
                if i + 1 < m and flag[i + 1][j] == 0:
                    i += 1                
                    res.append(matrix[i][j])
                    flag[i][j] = 1
                    end = 0
                else:
                    direct = 3
                    end += 1
            elif direct == 3:
                if j - 1 >= 0 and flag[i][j - 1] == 0:
                    j -= 1                
                    res.append(matrix[i][j])
                    flag[i][j] = 1
                    end = 0
                else:
                    direct = 4
                    end += 1
            elif direct == 4:
                if i - 1 >= 0 and flag[i - 1][j] == 0:
                    i -= 1                
                    res.append(matrix[i][j])
                    flag[i][j] = 1
                    end = 0
                else:
                    direct = 1
                    end += 1
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
    print(s.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))