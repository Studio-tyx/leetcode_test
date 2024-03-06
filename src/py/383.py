class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        hash = {}
        for i in range(len(magazine)):
            if magazine[i] not in hash:
                hash[magazine[i]] = 1
            else:
                hash[magazine[i]] += 1
        for i in range(len(ransomNote)):
            if ransomNote[i] not in hash:
                return False
            else:
                hash[ransomNote[i]] -= 1
                if hash[ransomNote[i]] < 0:
                    return False
        return True


if __name__ == "__main__":
    s = Solution()
    print(s.canConstruct(ransomNote = "a", magazine = "b"))
    print(s.canConstruct(ransomNote = "aa", magazine = "ab"))
    print(s.canConstruct(ransomNote = "aa", magazine = "aab"))