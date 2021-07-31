/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public Node cloneGraph(Node node) {
        /* 
        space O(N+E) time O(N+E) 
        E: no. of edges, N: no. of nodes
        */

        if (node == null) {
            return null;
        }
        
        /* 1. generate an adj list, ArrayList of ArrayList */
        
        /* Store node.val, neighbors' idxes */
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            
            /* avoid cycle */
            if (curr == null || adjMap.containsKey(curr.val)) {
                continue;
            }
            
            ArrayList<Integer> neighborIdxes = new ArrayList<>();
            
            if (curr.neighbors != null) {
                for (Node nb : curr.neighbors) {
                    neighborIdxes.add(nb.val);
                }
                    
                stack.addAll(curr.neighbors);
            }
            adjMap.put(curr.val, neighborIdxes);
        }
        
        //System.out.println(adjMap);
        
        /* 2. adj list -> newGraph */
        
        /* 2.1 generate keys -> nodes, empty neighbors */
        int length = adjMap.size();
        Node[] nodes = new Node[length];
        for (int i=0;i<length;i++) {
            ArrayList<Node> nbs = new ArrayList<Node>();
            nodes[i] = new Node(i+1, nbs);
        }
        
        
        /* 2.2 get neighbors from generated nodes */
        for (int val=1; val<=length; val++) {
            // current node's neighbors
            List<Node> nbs = nodes[val-1].neighbors;
            // get neighbors' idxes
            ArrayList<Integer> nbVals = adjMap.get(val);
            for (Integer nbVal : nbVals) {
                nbs.add(nodes[nbVal-1]);
            }
        }
        
        
        /* 3. return the node with same val as input node */
        return nodes[node.val-1];
    }

}