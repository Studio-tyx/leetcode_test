# Some solutions for LeetCode problems.
我还是换成hot100了...

problem1：哈希的做法还是很精妙的，手上拿着要插入的数据，就不会和哈希表里已有的数据重复了

problem283:第一反应用链表，但是是原地修改。后来仔细想了想好像也不难（奇怪的思路）

problem11:这个题的双指针移动条件还挺难想的:

+ 找左板和右板中比较小的一个板去往里缩。因为如果缩小板的话，里面还有可能会找到稍大一点的板；缩大板的话，一定不可能增加面积。

problem15:三数之和，老老实实双指针就行

problem3&problem438:滑动窗口杀我！但是如果真的想到是滑动窗口又很模板化，可以看[这个](https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/9749/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/?envType=study-plan-v2&envId=top-100-liked)

problem560:前缀和很容易想，但是用哈希表优化不太容易想

problem239:deque单调队列

problem41:感觉不太容易想得到[思路](https://leetcode.cn/problems/first-missing-positive/solutions/304743/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)

problem141:环形追击问题，其实快慢指针一定会相遇，不用管时间复杂度的问题

problem200:dfs有空的时候还是要再去好好[学习](https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/?envType=study-plan-v2&envId=top-100-liked)一下的

problem98:编码是不难的，主要是递归的判断条件有点难想，我一直以为是keep最大最小值往上递归的，没想到可以keep边界往下递归

problem207:不用递归也太难写了！

可以参考[这个](https://zhuanlan.zhihu.com/p/349940945)