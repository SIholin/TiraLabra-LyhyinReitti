package ui;

import algorithms.BreadthFirstSearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class UI {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Anna labyrintin leveys");
        int widht = reader.nextInt();
        System.out.println("Anna labyrintin korkeus");
        int height = reader.nextInt();
        
       
        
        System.out.println("Anna labyrintti (0 on seinä ja 1 on mahdollinen kulkusuunta)");
        
       
       
        int[][] graph = new int[widht][height];
        for(int r = 0; r < widht; r++) {
            for(int c = 0; c < height; c ++) {
                graph[r][c] = reader.nextInt();
            }
        }
       
        printGraph(widht, height, graph);
        
        BreadthFirstSearch bfs = new BreadthFirstSearch(widht, height, graph);
        bfs.BFS();
    }
    private static void AstartAlgorithm(int[][] graph) {
        
    
        ArrayList<String> openList = new ArrayList();
        ArrayList<String> colsedList = new ArrayList();
        
        openList.add("graph[0][0]");
        
    }
    
    private static void printGraph(int widht, int height, int[][] graph) {
        System.out.println("\nMaze: ");
        for (int i = 0; i < height; i ++) {
            printALineOfStart(i, widht, graph);
            System.out.println("");
        }
    }
    
    private static void printALineOfStart(int y, int widht, int[][] graph) {
        
        for (int i = 0; i < widht; i ++) {
            System.out.print(graph[y][i] + " ");
        }
    }
    
    
    
}
