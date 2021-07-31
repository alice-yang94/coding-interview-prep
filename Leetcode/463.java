class Solution {
    public int islandPerimeter(int[][] grid) {
        /* space O(1) time O(MN) */
        int rows = grid.length;
        int cols = grid[0].length;
        
        int peri = 0;
        
        for (int ri=0; ri<rows; ri++) {
            for (int cj=0; cj<cols; cj++) {
                if (grid[ri][cj] == 1) {
                    
                    // up 
                    if (ri == 0) {
                        peri += 1;
                    } else{
                        peri += 1 - grid[ri-1][cj];
                    }
                    
                    // down
                    if (ri == rows-1) {
                        peri += 1;
                    } else {
                        peri += 1 - grid[ri+1][cj];
                    }
                    
                    // left
                    if (cj == 0) {
                        peri += 1;
                    } else{
                        peri += 1 - grid[ri][cj-1];
                    }
                    
                    // right
                    if (cj == cols-1) {
                        peri += 1;
                    } else{
                        peri += 1 - grid[ri][cj+1];
                    }
                }
            }
        }
        
        return peri;
    }

}