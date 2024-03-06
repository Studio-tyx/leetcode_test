class Solution(object):
    def rotate(self, matrix):
        n = len(matrix)
        for level in range(int(n / 2)):
            for i in range(n - 2 * level - 1):
                temp = matrix[level][level + i]
                matrix[level][level + i] = matrix[n - 1 - i - level][level] 
                matrix[n - 1 - i - level][level] = matrix[n - 1 - level][n - 1 - i - level]
                matrix[n - 1 - level][n - 1 - i - level] = matrix[level + i][n - 1 - level]
                matrix[level + i][n - 1 - level] = temp
        # self.show(matrix)

    def show(self, matrix):
        for i in matrix:
            for j in i:
                print(j, end=",")
            print()

if __name__ == "__main__":
    s = Solution()
    s.rotate([[1,2,3],[4,5,6],[7,8,9]])
    s.rotate([[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]])