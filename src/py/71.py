class Solution(object):
    def simplifyPath(self, path):
        dirs = path.split('/')
        stack = []
        for dir in dirs:
            if dir != '':
                if dir == '..':
                    if len(stack) != 0:
                        stack.pop()
                elif dir != '.':
                    stack.append(dir)
        res = ''
        for dir in stack:
            res += '/' + dir
        if len(stack) == 0: res += "/"
        return res


if __name__ == "__main__":
    s = Solution()
    print(s.simplifyPath("/home/"))
    print(s.simplifyPath("/../"))
    print(s.simplifyPath("/home//foo/"))
    print(s.simplifyPath("/a/./b/../../c/"))