class Solution(object):
    def groupAnagrams(self, strs):
        h = {}
        for word in strs:
            sorted_str = sorted(word)
            sorted_str = ''.join(sorted_str)
            if sorted_str not in h:
                h[sorted_str] = [word]
            else:
                h[sorted_str].append(word)
        res = []
        for key in h:
            res.append(h[key])
        return res
            

if __name__ == "__main__":
    s = Solution()
    print(s.groupAnagrams(strs = ["eat", "tea", "tan", "ate", "nat", "bat"]))
    print(s.groupAnagrams([""]))
    print(s.groupAnagrams(["a"]))