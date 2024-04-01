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