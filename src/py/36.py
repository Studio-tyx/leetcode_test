# 大模拟，有耐心照做就行，不用被吓到
class Solution(object):
    def isValidSudoku(self, board):
        res = True
        for i in range(9):
            flag = {}
            for j in range(9):
                if board[i][j] != ".":
                    if board[i][j] not in flag:
                        flag[board[i][j]] = 0
                    else: 
                        return False
                        
        for j in range(9):
            flag = {}
            for i in range(9):
                if board[i][j] != ".":
                    if board[i][j] not in flag:
                        flag[board[i][j]] = 0
                    else: 
                        return False
        for three in range(3):
            flag = [{}, {}, {}]
            for i in range(3):
                for j in range(9):
                    if board[i + three * 3][j] != ".":
                        if board[i + three * 3][j] not in flag[int(j / 3)]:
                            flag[int(j/3)][board[i + three * 3][j]] = 0
                        else:
                            return False
        return res                             


if __name__ == "__main__":
    s = Solution()
    print(s.isValidSudoku(board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))
    print(s.isValidSudoku(board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))
