class Solution(object):
    def gameOfLife(self, board):
        m = len(board)
        n = len(board[0])
        big_board = []
        temp = []
        for i in range(n + 2):
            temp.append(0)
        big_board.append(temp)
        for i in range(m):
            line = [0]
            line.extend(board[i])
            line.append(0)
            big_board.append(line)
        big_board.append(temp)

        for i in range(m):
            for j in range(n):
                count = self.judge(big_board, i + 1, j + 1)
                if board[i][j] == 0:
                    if count == 3: board[i][j] = 1
                else:
                    if count == 2 or count == 3: board[i][j] = 1
                    else: board[i][j] = 0

        # self.show(board)

    def judge(self, bigboard, i, j):
        count = bigboard[i-1][j-1] + bigboard[i-1][j] + bigboard[i-1][j+1] + bigboard[i][j-1] + bigboard[i][j+1] + bigboard[i+1][j-1] + bigboard[i+1][j] + bigboard[i+1][j+1]
        return count
    
    def show(self, matrix):
        for line in matrix:
            for j in line:
                print(j, end=",")
            print()



if __name__ == "__main__":
    s = Solution()
    s.gameOfLife(board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]])
    s.gameOfLife([[1,1],[1,0]])