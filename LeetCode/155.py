'''Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.'''


class MinStack(object):                                     #栈的实现，且实现去栈中最小值的方法
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        
    def push(self, x):                                       #push的时候，把x与栈中取出的最小值比较并取较小者，组成一个元组再压进栈中，
        """                                                  #保证栈中每一个元素都捆绑有一个栈中最小值，         
        :type x: int
        :rtype: None
        """
        MIN = self.getMin()
        if  MIN==None or MIN>x:
            MIN = x
        self.stack.append((x,MIN))

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()                                     #弹出元素的时候，即便最小值被弹了出去，其余元素也有捆绑着剩余元素最小值的功能

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack):
            return self.stack[-1][0]
        else:
            return None

    def getMin(self):                                     #取出最小值，末尾元组的[1]
        """
        :rtype: int
        """
        if not len(self.stack):
            return None
        else:
            return self.stack[-1][1]
