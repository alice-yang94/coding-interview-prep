"""
Singly linked list and Doubly linked list classes are implemented to assist 
completing questions in chapter2 of CCI

Both classes take an integer array as input and the array will be transformed 
to each list respectively by helper functions.
"""
class SinglyLinkedList:
    def __init__(self, elemList):
        self.head = self._listToSLL(elemList)
    
    def __str__(self):
        if not self.head:
            return "Error: This is an empty list."
        
        sll_list = []
        curr = self.head
        
        while curr:
            sll_list.append(str(curr.val))
            curr = curr.next
        
        return " -> ".join(sll_list)
    
    # helper function: transform list to SLL
    def _listToSLL(self, l):
        if len(l) == 0:
            return None

        head = Node(l[0])
        curr = head
        for elem in l[1:]:
            curr.next = Node(elem)
            curr = curr.next
        return head
        
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
        
        dll_list = []
        curr = self.head
        while curr:
            dll_list.append(str(curr.val))
            curr = curr.next
        return " <-> ".join(dll_list)
    
    # helper function: transform list to DLL
    def _listToDLL(self, l):
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
        
class DNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None