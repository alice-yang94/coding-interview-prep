class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        return self.arrayStringsAreEqual2(word1,word2)
    
    def arrayStringsAreEqual1(self, word1: List[str], word2: List[str]) -> bool:
        """
        time O(n)
        space O(n)
        """
        word1str = ''.join(word1)
        word2str = ''.join(word2)
        return word1str == word2str
    
    def arrayStringsAreEqual2(self, word1: List[str], word2: List[str]) -> bool:
        """
        Treat words as 2D array and use two pointers to traverse
        
        time O(n)
        space O(1)
        """
        
        # i for list idx, j for str idx
        i1 = 0
        j1 = 0
        i2 = 0
        j2 = 0
        
        while i1 < len(word1) and i2 < len(word2):
            if word1[i1][j1] != word2[i2][j2]:
                return False
            
            # update word1 indexes
            if j1 < len(word1[i1])-1:
                j1 += 1
            else:
                i1 += 1
                j1 = 0
            
            # update word2 indexes
            if j2 < len(word2[i2])-1:
                j2 += 1
            else:
                i2 += 1
                j2 = 0
        
        if i1 == len(word1) and i2 == len(word2):
            return True
        
        return False