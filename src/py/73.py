class Solution(object):
    def setZeroes(self, matrix):
        lines = []
        rows = []
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 0:
                    lines.append(i)
                    rows.append(j)
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if i in lines or j in rows:
                    matrix[i][j] = 0
        self.show(matrix)

    def show(self, matrix):
        for line in matrix:
            for j in line:
                print(j, end=",")
            print()

if __name__ == "__main__":
    s = Solution()
    s.setZeroes([[1,1,1],[1,0,1],[1,1,1]])
    s.setZeroes([[0,1,2,0],[3,4,5,2],[1,3,1,5]])