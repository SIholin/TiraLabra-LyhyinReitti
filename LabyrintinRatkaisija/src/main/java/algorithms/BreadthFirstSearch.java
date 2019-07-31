package algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {

    int x, y, dist;
    
    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class BreadthFirstSearch {
    
    //Size of maze
    private int widht;
    private int height;
    
    //Maze giving by user 
    private int[][] maze;
    
    //Possible movements from a cell (previous, next, up and down)
    private int row[] = {-1, 0, 0, 1};
    private int col[] = {0, -1, 1, 0};
    
    //Constructor of class. It get weight, height and maze from main class
    public BreadthFirstSearch(int widht, int height, int[][] maze) {
        this.widht = widht;
        this.height = height;
        this.maze = maze;
                
    }
    
    public void BFS() {
        
        int i = 0;
        int j = 0;
        int x = widht -1;
        int y = height -1;
        
        if (maze[i][j] == 0 || maze[x][y] == 0) {
            System.out.println("Labyrintti on mahdoton");
            return;
        }
        
        boolean[][] visited = new boolean[widht][height];
        
        Queue<Node> q = new ArrayDeque<>();
        
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
        
        int min_dist = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            i = node.x;
            j = node.y;
            int dist = node.dist;
            
            if (i == x && j == y) {
                min_dist = dist;
                break;
            }
            
            for (int k = 0; k < 4; k++) {
                if (isPossible(visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }
        
        if(min_dist != Integer.MAX_VALUE) {
            System.out.print("Lyhyimmän reitin pituus on " + min_dist);
        } else {
            System.out.println("Labyrintti on mahdoton");
        }
        
    }
    //Check is it possible to go maze[row][col]. If it is not possible function 
    //retruns false else true. It is not possible if it is already visited or 
    //outside of maze or the value of possible position is 0. 
    private boolean isPossible(boolean visited[][], int r, int c) {
        return (r >= 0) && (r < widht) && (c >= 0) && (c < height)
                && maze[r][c] == 1 && !visited[r][c];
    }
    
    
    
    
}
