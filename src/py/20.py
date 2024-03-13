class Solution(object):
    def isValid(self, s):
        stack = []
        for ch in s:
            if ch == '{' or ch == '(' or ch == '[':
                stack.append(ch)
            else:
                if len(stack) != 0:
                    if stack[-1] == '[' and ch == ']':
                        stack.pop()
                        continue
                    elif stack[-1] == '{' and ch == '}':
                        stack.pop()
                        continue
                    elif stack[-1] == '(' and ch == ')':
                        stack.pop()
                        continue
                    else:
                        return False
                else:
                    return False
        if len(stack)!= 0: return False
        else: return True
    

if __name__ == "__main__":
    s = Solution()
    print(s.isValid("()"))
    print(s.isValid("()[]{"))
    print(s.isValid("()[}"))