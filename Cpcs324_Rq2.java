package Cpcs324_Rq2;

import javafx.util.Pair;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author najd
 */
public class Cpcs324_Rq2 {

    /**
     * prints the main menu 
     */
    public static void main(String[] args) {
       
        int n = 0, m = 0, Choice = -1;
        Scanner in = new Scanner(System.in);
        // menu do while 
        do {
            System.out.println("\t\t*** Test and Compare Different Minimum Spanning Tree Algorithms ***");
            System.out.println("1- Kruskal's Algorithm & Prim's Algorithm (based on Min Heap)");
            System.out.print("> Enter your choice : ");
            Choice = in.nextInt();
            if (Choice != 1 ) {
                System.out.println("****Invalid input!****");
            }
            // menu break condition 
        } while (Choice != 1 );
        if (Choice == 1 ) {
            System.out.println("> Available cases (where n represents # of vertices and m represents # of edges: )");
            System.out.println(" 1-  n=1,000 - m=10,000");
            System.out.println(" 2-  n=1,000 - m=15,000");
            System.out.println(" 3-  n=1,000 - m=25,000");
            System.out.println(" 4-  n=5,000 - m=15,000");
            System.out.println(" 5-  n=5,000 - m=25,000");
            System.out.println(" 6- n=10,000 - m=15,000");
            System.out.println(" 7-  n=10,000 - m=25,000");
            System.out.print("> Enter a case to test: ");
            int choice = in.nextInt();
            // switch for all avaliable cases of the test 
            while (choice < 1 || choice > 7) {
                System.out.println("Invalid input!");
                System.out.print("> Enter a case to test: ");
                choice = in.nextInt();
            }
            switch (choice) {
                case 1: {
                    n = 1000;
                    m = 10000;
                }
                break;
                case 2: {
                    n = 1000;
                    m = 15000;
                }
                break;
                case 3: {
                    n = 1000;
                    m = 25000;
                }
                break;
                case 4: {
                    n = 5000;
                    m = 15000;
                }
                break;
                case 5: {
                    n = 5000;
                    m = 25000;
                }
                break;
                case 6: {
                    n = 10000;
                    m = 15000;
                }
                break;
                case 7: {
                    n = 10000;
                    m = 25000;
                }
                break;
                
            }
          Graph graph = new Graph(n, m);
          graph.make_graph(graph);
//          // to perform kruskal and prim min heap
          if (Choice == 1) {
            graph.kruskal();
//            graph.PrimMinHeap();
//      
        }
        
    }
} 
}
    