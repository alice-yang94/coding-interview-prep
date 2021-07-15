class SinglyLinkedList:
    def __init__(self, head):
        self.head = head
    
    def __str__(self):
        if not self.head:
            return "Error: This is an empty list."
        
        sll_list = []
        curr = self.head
        
        while curr:
            sll_list.append(str(curr.val))
            curr = curr.next
        
        return " -> ".join(sll_list)
        
class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        

class DoublyLinkedList:
    def __init__(self, head):
        self.head = head
        
    def __str__(self):
        if not self.head:
            return "Error: This is an empty list."
        
        dll_list = []
        curr = self.head
        while curr:
            dll_list.append(str(curr.val))
            curr = curr.next
        return " <-> ".join(dll_list)
        
class DNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None