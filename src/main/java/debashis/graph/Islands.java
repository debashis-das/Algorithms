package debashis.graph;

import java.util.Stack;

/**
 * Find the number of islands
 *
 * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.
 *
 * Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 *
 * Example 1:
 *
 * Input:
 * grid = {{0,1},{1,0},{1,1},{1,0}}
 * Output:
 * 1
 * Explanation:
 * The grid is-
 * 0 1
 * 1 0
 * 1 1
 * 1 0
 * All lands are connected.
 * Example 2:
 *
 * Input:
 * grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
 * Output:
 * 2
 * Expanation:
 * The grid is-
 * 0 1 1 1 0 0 0
 * 0 0 1 1 0 1 0
 * There are two islands :- one is colored in blue
 * and other in orange.
 * Your Task:
 * You don't need to read or print anything. Your task is to complete the function numIslands() which takes the grid as an input parameter and returns the total number of islands.
 *
 * Expected Time Complexity: O(n*m)
 * Expected Space Complexity: O(n*m)
 *
 * Constraints:
 * 1 ≤ n, m ≤ 500
 */
public class Islands {

    int[][] movement = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    class Cordinates {
        int x;
        int y;

        Cordinates(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Islands islands = new Islands();
//        int[][] grid = {{0,1},{1,0},{1,1},{1,0}};
        int[][] grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
        System.out.println(islands.noOfIslands(grid));
    }

    private int noOfIslands(int[][] grid) {
        int islands = 0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    Stack<Cordinates> stack = new Stack<>();
                    stack.push(new Cordinates(i,j));
                    while(!stack.isEmpty()){
                        Cordinates current = stack.pop();
                        grid[current.x][current.y] = 2;
                        for(int[] temp : movement){
                            int newX = current.x + temp[0];
                            int newY = current.y + temp[1];
                            if(newX>=0 && newX < grid.length && newY >= 0 && newY <grid[0].length && grid[newX][newY] == 1){
                                stack.push(new Cordinates(newX,newY));
                            }
                        }
                    }
                    ++islands;
                }
            }
        }
        return islands;
    }
}
