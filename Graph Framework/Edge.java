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

public class Edge implements Comparator<Edge> {
    
    Vertex parent;
    Vertex source;
    Vertex target;
    int weight;
    
    public Edge() {}
    
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Edge(Vertex parent, Vertex source, Vertex target, int weight) {
        this.parent = parent;
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public int compare(Edge edge1, Edge edge2){
 
        if (edge1.weight < edge2.weight) return -1;
 
        if (edge1.weight > edge2.weight) return 1;
 
        return 0;
    }
    
    public void displayInfo() {
    }
    
}
