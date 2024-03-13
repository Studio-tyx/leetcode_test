# strange reason for int((val1/float(val2)) and int((val1/(val2))

class Solution(object):
    def evalRPN(self, tokens):
        stack = []
        for token in tokens:
            if token == '/':
                val2 = stack.pop()
                val1 = stack.pop()
                stack.append(int((val1/float(val2))))
            elif token == '*':
                stack.append(stack.pop() * stack.pop())
            elif token == '+':
                stack.append(stack.pop() + stack.pop())
            elif token == '-':
                val2 = stack.pop()
                val1 = stack.pop()
                stack.append(val1 - val2)
            else:
                stack.append(int(token))
        return stack[0]


if __name__ == "__main__":
    s = Solution()
    print(s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))
    print(s.evalRPN(["2","1","+","3","*"]))
    print(s.evalRPN(["4","13","5","/","+"]))