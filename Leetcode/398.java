import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Solution {
    /**
    Initialise the dups HashMap to store all dups 
    time: O(n), space O(n)
    
    For every pick: time O(1)
     */
    
    private int[] nums;
    private HashMap<Integer, ArrayList> dups;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.dups = this.initialiseDups(nums);
    }
    
    public int pick(int target) {
        if (!this.dups.containsKey(target)){
            
            return 0;
        }
        ArrayList<Integer> dupList = this.dups.get(target);
        int len = dupList.size();
        // create instance of Random class
        Random rand = new Random();
        // Generate random integers in range [0, length)
        int randIdx = rand.nextInt(len);
        
        return dupList.get(randIdx);
    }
    
    private HashMap<Integer, ArrayList> initialiseDups(int[] nums) {
        HashMap<Integer, ArrayList> dups = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (dups.containsKey(num)) {
                // add idx of num to dups list 
                ArrayList<Integer> dupList = dups.get(num);
                dupList.add(i);
            } else {
                // put new arraylist with key num
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i));
                dups.put(num, list);
            }
        }
        
        return dups;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */