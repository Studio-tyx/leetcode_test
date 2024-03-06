class Solution(object):
    def isAnagram(self, s, t):
        hash = {}
        if len(s) != len(t): return False
        for i in range(len(s)):
            if s[i] not in hash:
                hash[s[i]] = 1
            else:
                hash[s[i]] += 1
        for i in range(len(t)):
            if t[i] not in hash:
                return False
            else:
                hash[t[i]] -= 1
                if hash[t[i]] < 0:
                    return False
        return True
    

if __name__ == "__main__":
    s = Solution()
    print(s.isAnagram(s = "anagram", t = "nagaram"))
    print(s.isAnagram(s = "rat", t = "car"))