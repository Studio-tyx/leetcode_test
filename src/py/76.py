# 被骗了，我还以为要按顺序的最小子串
class Solution(object):
    def minWindow(self, s, t):
        tmap = {}
        for t_i in t:
            if t_i not in tmap:
                tmap[t_i] = 1
            else:
                tmap[t_i] += 1
        start = 0
        end = 0
        window = {}
        count = 0
        res = len(s)
        res_str = ""
        while start != len(s):
            if end == len(s) and count < len(t):break
            if count == len(t):
                while count >= len(t) and start != len(s):
                    sta = s[start]
                    if sta in tmap:
                        if window[sta] == tmap[sta]:
                            count -= 1
                            if count == len(t) - 1:
                                if end - start <= res: 
                                    res_str = s[start:end]
                                    res = end - start
                        window[sta] -= 1
                    start += 1
                    
            else:
                while count < len(t) and end != len(s):
                    ch = s[end]
                    if ch in tmap:
                        if ch not in window:
                            window[ch] = 1
                        else:
                            window[ch] += 1
                        if window[ch] <= tmap[ch]: count += 1
                    end += 1

            if count == len(t):
                if end - start <= res: 
                    res_str = s[start:end]
                    res = end - start
        return res_str

if __name__ == "__main__":
    s = Solution()
    print(s.minWindow(s = "ADOBECODEBANC", t = "ABC"))
    print(s.minWindow(s = "a", t = "a"))
    print(s.minWindow(s = "a", t = "aa"))