class Solution(object):
    def lengthOfLongestSubstring(self, s):
        dic = {}
        a = 0
        res = 0
        for i in range(len(s)):
            if s[i] in dic:
                a = max(a, dic[s[i]] + 1)
                res = max(res, i - a + 1)
                dic[s[i]] = i
            else:
                dic[s[i]] = i
                res = max(res, i - a + 1)
        return res
    

if __name__ == "__main__":
    s = Solution()
    print(s.lengthOfLongestSubstring("abcabcbb"))
    print(s.lengthOfLongestSubstring("bbbbb"))
    print(s.lengthOfLongestSubstring("ababab"))
    print(s.lengthOfLongestSubstring("abbaabbba"))
    print(s.lengthOfLongestSubstring("pwwkew"))