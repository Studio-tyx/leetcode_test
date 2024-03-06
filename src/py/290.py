class Solution(object):
    def wordPattern(self, pattern, s):
        words = s.split(" ")
        h = {}
        back = {}
        if len(pattern) != len(words): return False
        for i in range(len(words)):
            if words[i] not in h:
                if pattern[i] not in back:
                    h[words[i]] = pattern[i]
                    back[pattern[i]] = words[i]
                else:
                    return False
            else:
                if pattern[i] != h[words[i]]:
                    return False
        return True


if __name__ == "__main__":
    s = Solution()
    print(s.wordPattern(pattern = "abba", s = "dog cat cat dog"))
    print(s.wordPattern(pattern = "abba", s = "dog cat cat fish"))
    print(s.wordPattern(pattern = "aaaa", s = "dog cat cat dog"))
    print(s.wordPattern("aaa", "aa aa aa aa"))