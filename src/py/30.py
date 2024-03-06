# 非常暴力的解法，感谢没有超时hhhh
class Solution(object):
    def findSubstring(self, s, words):
        n = len(words[0])
        mn = n * len(words)
        res = []
        start = 0
        words.sort()
        while(start != len(s)):
            tmp_str = []
            end = start
            while(end < start + mn):
                tmp_str.append(s[end: end + n])
                end += n
            tmp_str.sort()
            print(tmp_str, words)
            if tmp_str == words:
                res.append(start)
            start += 1
        return res
        
if __name__ == "__main__":
    s = Solution()
    # print(s.findSubstring(s = "barfoothefoobarman", words = ["foo","bar"]))
    # print(s.findSubstring(s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]))
    # print(s.findSubstring(s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]))
    print(s.findSubstring(s = "lingmindraboofooowingdingbarrwingmonkeypoundcake", words = ["fooo","barr","wing","ding","wing"]))