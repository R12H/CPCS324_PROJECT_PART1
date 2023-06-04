
package PhoneNetworkApp;
import javafx.util.Pair;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import GraphFramework.Graph;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class PhoneNWDesignApp extends BluePrintsGraph{

 public static void main(String[] args) throws FileNotFoundException {
       
        //
        int n = 0, m = 0, Choice = -1;
        
        //virable to calcolat the time
        double StartTime, FinishTime, totalTime;
        
        //
        File file = new File("Graph.txt");
        
        Scanner in = new Scanner(System.in);
        //array of m and n size
        int [][] size = {{1000, 10000} , {1000, 15000} ,{1000, 25000} , 
                         {5000, 15000} , {5000, 25000} ,
                         {10000, 15000} , {10000, 25000}}; 
        // menu do while 
        do {
            System.out.println("\t\t*** Test and Compare Different Minimum Spanning Tree Algorithms ***");
            System.out.println("1- Kruskal's Algorithm & Prim's Algorithm (based on Min Heap)");
            System.out.println("0- Exit");
            System.out.print("> Enter your choice : ");
            Choice = in.nextInt();
            if (Choice > 1 && Choice < 0) {
                System.out.println("****Invalid input!****");
            }
            // menu break condition 
        } while (Choice != 1 && Choice != 0);
        if (Choice == 1) {
            System.out.println("1- Experimental comparison of two of Algorthim");
            System.out.println("2- Read gragh from file");
            System.out.println("3- Chose from available cases");
            System.out.print("> Enter your choice: ");
            Choice = in.nextInt();
            // switch for all avaliable choice 
                while (Choice < 1 || Choice > 3) {
                    System.out.println("Invalid input!");
                    System.out.print("> Enter your choice: ");
                    Choice = in.nextInt();
                }
            switch (Choice) {
                case 1: {
                    // number of trial of each case
                    int numberOfTrial = 10;
                    // number of cases
                    int numberOfCase = 7;
                    
                    //two arrays to save algorthim time
                    double [][] kruskalTime = new double[numberOfCase][numberOfTrial];
                    double [][] primTime = new double[numberOfCase][numberOfTrial];
                    
                    for(int i = 0; i < numberOfCase; i++){
                        for(int j = 0; j < numberOfTrial; j++){
                            n = size[i][0];
                            m = size[i][1];
                            
                            BluePrintsGraph phLNetwork = new BluePrintsGraph(n, m);
                            
                            System.out.print("n = " + n + "  m = " + m);
                            //make random graph
                            phLNetwork.makeGraph(n, m);
                            
                            //calcolate kruskal time
                            StartTime = System.currentTimeMillis();
                            //to perform kruskal and prim min heap
                            phLNetwork.kruskal();
                            FinishTime = System.currentTimeMillis();
                            totalTime = FinishTime - StartTime;
                            kruskalTime [i][j] = totalTime;
                            System.out.println("Total runtime of Kruskal's Algorithm: " + totalTime + " ms.");
        
                            //calcolate prim time
                            StartTime = System.currentTimeMillis();
                            //to perform prim min heap
                            //prim
                            FinishTime = System.currentTimeMillis();
                            totalTime = FinishTime - StartTime;
                            primTime [i][j] = totalTime;
                            System.out.println("Total runtime of Prim's Algorithm: " + totalTime + " ms.");
                            //-------------------------------------------------\\
                                 
                        }
                    }
                    //display the resulte
                    displayTime(kruskalTime ,primTime, size);
                }
                break;
                case 2: {
                    BluePrintsGraph phLNetwork = new BluePrintsGraph();
                    phLNetwork.readGraphFromFile(file);

                    phLNetwork.kruskal();
                    
                    
                }
                break;
                case 3: {
                    System.out.println("> Available cases (where n represents # of vertices and m represents # of edges: )");
                    System.out.println(" 1-  n=1,000 - m=10,000");
                    System.out.println(" 2-  n=1,000 - m=15,000");
                    System.out.println(" 3-  n=1,000 - m=25,000");
                    System.out.println(" 4-  n=5,000 - m=15,000");
                    System.out.println(" 5-  n=5,000 - m=25,000");
                    System.out.println(" 6-  n=10,000 - m=15,000");
                    System.out.println(" 7-  n=10,000 - m=25,000");
                    System.out.print("> Enter a case to1 test: ");
                    Choice = in.nextInt();
                    // switch for all avaliable cases of the test 
                    while (Choice < 1 || Choice > 7) {
                        System.out.println("Invalid input!");
                        System.out.print("> Enter a case to test: ");
                        Choice = in.nextInt();
                    }
                    switch (Choice) {
                        case 1: {
                            //n = 1000;
                            //n = size[0][0];
                            n = 10;
                            //m = 10000;
                            //m = size[0][1];
                            m = 10;

                        }
                        break;
                        case 2: {
                            //n = 1000;
                            n = size[1][0];
                            //m = 15000;
                            m = size[2][1];
                        }
                        break;
                        case 3: {
                            //n = 1000;
                            n = size[3][0];
                            //m = 25000;
                            m = size[3][1];
                        }
                        break;
                        case 4: {
                            //n = 5000;
                            n = size[4][0];
                            //m = 15000;
                            m = size[4][1];
                        }
                        break;
                        case 5: {
                            //n = 5000;
                            n = size[5][0];
                            //m = 25000;
                            m = size[5][1];
                        }
                        break;
                        case 6: {
                            //n = 10000;
                            n = size[6][0];
                            //m = 15000;
                            m = size[6][1];
                        }
                        break;
                        case 7: {
                            //n = 10000;
                            n = size[7][0];
                            //m = 25000;
                            m = size[7][1];
                        }
                        break;   
                  }
                  BluePrintsGraph phLNetwork = new BluePrintsGraph(n, m);
                  phLNetwork.makeGraph(n, m);
                  // to perform kruskal and prim min heap
                  phLNetwork.kruskal();
                  // graph.PrimMinHeap();
                     }
                    break;

        }      
    } 
       if (Choice == 0 ) {
            System.out.println("Have nice day! :)");
        }
       
       if (Choice < 1 && Choice > 3)
           System.out.println("****Invalid input!****"); 
    }
    public static void displayTime(double [][] a, double [][] b, int [][] c){
       System.out.println("\n\t\t\t\t\t\tkruska Algorithm time(ms)");
         System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t");
        for(int i = 0; i < a[0].length;i++)
            System.out.print("T" + (i + 1) + "\t\t");
        System.out.println();
        printTime(a, c);
        System.out.println();
        System.out.println("\n\t\t\t\t\t\t\t\tprim Algorithm time(ms)");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t");
        for(int i = 0; i < a[0].length;i++)
            System.out.print("T" + (i + 1) + "\t\t");
        System.out.println();
        printTime(b, c);
    }
     public static void printTime(double [][] a, int [][] c){
          for(int i=0;i<a.length;i++){
            System.out.print("n: " + c[i][0] + "| m: " + c[i][1] + "\t");
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + "\t\t");
                }
            System.out.println();
           }
         System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
}



