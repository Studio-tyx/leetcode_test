class Solution(object):
    def isIsomorphic(self, s, t):
        h = {}
        back = {}
        for i in range(len(s)):
            if s[i] not in h:
                if t[i] not in back:
                    h[s[i]] = t[i]
                    back[t[i]] = s[i]
                else:
                    return False
            else:
                if t[i] != h[s[i]]:
                    return False
        return True


if __name__ == "__main__":
    s = Solution()
    print(s.isIsomorphic(s = "egg", t = "add"))
    print(s.isIsomorphic(s = "foo", t = "bar"))
    print(s.isIsomorphic(s = "paper", t = "title"))