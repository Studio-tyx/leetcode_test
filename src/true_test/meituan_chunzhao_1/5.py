# 小美认为，在人际交往中，但是随着时间的流逝，朋友的关系也是会慢慢变淡的，最终朋友关系就淡忘了。
# 现在初始有一些朋友关系，存在一些事件会导致两个人淡忘了他们的朋友关系。小美想知道某一时刻中，某两人是否可以通过朋友介绍互相认识？
# 事件共有 2 种：
# 1 u v：代表编号 u 的人和编号 v 的人淡忘了他们的朋友关系。
# 2 u v：代表小美查询编号 u 的人和编号 v 的人是否能通过朋友介绍互相认识。

# 注：介绍可以有多层，比如 2 号把 1 号介绍给 3 号，然后 3 号再把 1 号介绍给 4 号，这样 1 号和 4 号就认识了。



import sys
class Node:
    no = 0
    next = []

if __name__ == "__main__":
    line = sys.stdin.readline().split()
    n = int(line[0])
    m = int(line[1])
    q = int(line[2])
    nodes = []
    for i in range(n + 1):
        node = Node()
        node.no = i
        node.next = []
        nodes.append(node)

    for i in range(m):
        line = sys.stdin.readline().split()
        nodes[int(line[0])].next.append(int(line[1]))
        nodes[int(line[1])].next.append(int(line[0]))
    
    for i in range(q):
        line = sys.stdin.readline().split()
        u = int(line[1])
        v = int(line[2])
        if line[0] == '1':
            if u in nodes[v].next:
                nodes[v].next.remove(u)
            if v in nodes[u].next:
                nodes[u].next.remove(v)
        elif line[0] == '2':
            current = {}
            flag = 0
            next_current = {u}
            reached = {u}
            len_reached = 0
            while len_reached != len(reached):
                current = next_current
                len_reached = len(reached)
                next_current = set()
                for node in current:
                    for addno in nodes[node].next:
                        next_current.add(addno)
                    if node in next_current: next_current.remove(node)
                if v in next_current:
                    flag = 1
                    break
                reached.update(next_current)
                # print(current, next_current, reached)

            if flag == 1:print("Yes")
            else:print("No")