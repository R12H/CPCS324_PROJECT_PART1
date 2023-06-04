/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  KruskalAlg: https://algorithms.tutorialhorizon.com/kruskals-algorithm-minimum-spanning-tree-mst-complete- java-implementation/
3)  MinHeap:  https://medium.com/@ankur.singh4012/implementing-min-heap-in-java-413d1c20f90d
4)  MHPrimAlg :  https://www.baeldung.com/java-prim-algorithm

Section:
CP1
 */

package GraphFramework;

import java.util.*;

public class Vertex {
    
    String label;
    boolean isVisited;
    LinkedList<Edge> adjList;
    
    public Vertex() {}
    
    public Vertex(String label) {
        this.label = label;
        isVisited = false;
        adjList = new LinkedList<>();
    }

    public String getLabel() {
        return label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public LinkedList<Edge> getAdjList() {
        return adjList;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    
    public void displayInfo( ) {

        System.out.print("Vertex No. "+ getLabel());
        
    }
    
}
