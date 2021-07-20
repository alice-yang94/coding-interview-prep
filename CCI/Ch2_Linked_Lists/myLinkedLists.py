"""
Singly linked list and Doubly linked list classes are implemented to assist 
completing questions in chapter2 of CCI

Both classes take an integer array as input and the array will be transformed 
to each list respectively by helper functions.
"""
from collections import deque

class SinglyLinkedList:
    def __init__(self, elems):
        self.head = elems
        if type(elems) is list:
            # if input is list, transform it to sll
            self.head = self._listToSLL(elems)
    
    def __str__(self):
        if not self.head:
            return "Error: This is an empty list."
        
        sll_list = []
        curr = self.head
        
        while curr:
            sll_list.append(str(curr.val))
            curr = curr.next
        
        return " -> ".join(sll_list)
    
    
    def _listToSLL(self, l):
        # helper function: transform list to SLL
        if len(l) == 0:
            return None

        head = Node(l[0])
        curr = head
        for elem in l[1:]:
            curr.next = Node(elem)
            curr = curr.next
        return head

    def toList(self):
        # transform SLL to array/list
        l = []
        curr = self.head
        while curr:
            l.append(curr.val)
            curr = curr.next
        return l
        
class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class DoublyLinkedList:
    def __init__(self, elemList):
        self.head = self._listToDLL(elemList)
        
    def __str__(self):
        if not self.head:
            return "Error: This is an empty list."
        
        # print next pointers -> forward order
        dll_list = []
        curr = self.head
        last = curr
        while True:
            dll_list.append(str(curr.val))
            if not curr.next:
                last = curr
                break
            curr = curr.next
        
        # print prev <- reverse order
        dll_list_rev = deque()
        curr = last
        while curr:
            dll_list_rev.appendleft(str(curr.val))
            curr = curr.prev

        return " -> ".join(dll_list) + '\n' + " <- ".join(dll_list_rev)
    
    
    def _listToDLL(self, l):
        # helper function: transform list to DLL
        if len(l) == 0:
            return None
        head = DNode(l[0])
        curr = head

        for elem in l[1:]:
            # curr -> elem
            curr.next = DNode(elem)
            # curr <- elem
            curr.next.prev = curr

            curr = curr.next

        return head
        
    def check(self):
        # check if all prev and next pointers match each other
        if not self.head:
            return False
        
        curr = self.head
        prev = None
        while curr:
            if curr.prev != prev:
                print(f'{curr.val} and its prev does not match')
                return False
            else:
                prev = curr
                curr = curr.next
        return True
    
    def toList(self):
        # transform DLL to array/list
        l = []
        if self.check():
            curr = self.head
            while curr:
                l.append(curr.val)
                curr = curr.next
        return l

class DNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None