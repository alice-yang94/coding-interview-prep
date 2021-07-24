/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.LinkedList;

class Solution {
    public int minDepth(TreeNode root) {
        // BFS traverse the tree until first leaf found, return depth
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> nodeq = new LinkedList();
        Queue<Integer> depthq = new LinkedList();
        
        nodeq.add(root);
        depthq.add(1);
         
        while (!nodeq.isEmpty() && !depthq.isEmpty()) {
            TreeNode curr = nodeq.poll();
            int depth = depthq.poll();
            
            if (curr.left == null && curr.right == null) {
                // curr is a leaf
                System.out.println("curr: "+curr.val);
                return depth;
            } 
            
            if (curr.left != null) {
                System.out.println("left: "+curr.left.val);
                
                nodeq.add(curr.left);
                depthq.add(depth+1);
            } 
            
            if (curr.right != null) {
                System.out.println("right: "+curr.right.val);
                
                nodeq.add(curr.right);
                depthq.add(depth+1);
            }
            
        }
        return 0;
        
    }
}