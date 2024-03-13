class MinStack(object):
    stack = []
    min_stack = []

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val):
        self.stack.append(val)
        if len(self.min_stack) == 0: self.min_stack.append(val)
        else: self.min_stack.append(min(self.min_stack[-1], val))

    def pop(self):
        self.min_stack.pop()
        return self.stack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.min_stack[-1]

if __name__ == "__main__":
    # minStack = MinStack()
    # minStack.push(-2)
    # minStack.push(0)
    # minStack.push(-3)
    # print(minStack.getMin())
    # print(minStack.pop())
    # print(minStack.top())
    # print(minStack.getMin())
    m = MinStack()
    m.push(-1)
    print(m.top())
    print(m.getMin())