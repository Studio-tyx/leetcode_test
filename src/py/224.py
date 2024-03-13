class Solution(object):
    def calculate(self, s):
        stack = [1]
        now_sign = 1
        res = 0
        i = 0
        while i < len(s):
            if s[i] == '(':
                stack.append(now_sign)
                i += 1
            elif s[i] == ' ':
                i += 1
            elif s[i] == ')':
                stack.pop()
                now_sign = stack[-1]
                i += 1
            elif s[i] == '+':
                now_sign = stack[-1]
                array.append(',-' if now_sign == -1 else ',+')
                i += 1
            elif s[i] == '-':
                now_sign = -stack[-1]
                array.append(',-' if now_sign == -1 else ',+')
                i += 1
            else:
                tmp = 0
                while i<len(s) and s[i].isdigit():
                    tmp = tmp * 10 + int(s[i])
                    i += 1
                res += tmp * now_sign
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.calculate("- (3 + (4 + 5))"))
    # print(s.calculate("(1+(4+5+2)-3)+(6+8)"))
    # print(s.calculate(" 2-1 + 2 "))
    # print(s.calculate('1+2+30+23'))