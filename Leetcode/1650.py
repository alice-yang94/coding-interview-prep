"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        return self.lowestCommonAncestor2(p,q)
        
    def lowestCommonAncestor2(self, p: 'Node', q: 'Node') -> 'Node':
        """
        n is the number of elements in the tree
        time O(n)   
        space O(1)
        
        try to get height of p,q to avoid store all ancestors
        """
        # get height of p and q
        hp = self.getHeight(p)
        hq = self.getHeight(q)
        
        diff_h = abs(hp-hq)
        short = p if hp < hq else q
        tall = q if hp < hq else p
        
        # let the taller node move diff_h steps up, so that p,q are at the same level
        for i in range(diff_h):
            tall = tall.parent
        
        # compare and move p,q up at the same time
        while tall and short:
            if tall.val == short.val:
                return tall
            tall = tall.parent
            short = short.parent
        
        return None
    
    def getHeight(self, node):
        if not node:
            return -1
        h = 0
        curr = node
        while curr.parent:
            h += 1
            curr = curr.parent
        return h
    
    def lowestCommonAncestor1(self, p: 'Node', q: 'Node') -> 'Node':
        """
        n is the number of elements in the tree
        time O(n)   
        space O(n)  
        """
        pIsAncestor = self.isAncestorOf(p,q)
        if pIsAncestor:
            return p
        qIsAncestor = self.isAncestorOf(q,p)
        if qIsAncestor:
            return q
        
        # p,q from different branches
        # 1. get p's ancestors
        p_ans = self.getAncestors(p)
        
        # 2. get p&q's common ancestor
        return self.getCommonAncestor(p_ans, q)
    
    def getCommonAncestor(self, p_ans, q):
        curr = q
        while curr.parent:
            if curr.parent.val in p_ans:
                return curr.parent
            curr = curr.parent
        return None
    
    def getAncestors(self, node):
        curr = node
        ancestors = set()
        while curr.parent:
            ancestors.add(curr.parent.val)
            curr = curr.parent
        return ancestors
    
    def isAncestorOf(self, anc, child):
        if not anc or not child:
            return False
        if anc.val == child.val:
            return True
        
        found = self.isAncestorOf(anc.left, child)
        if not found:
            found = self.isAncestorOf(anc.right, child)
        return found