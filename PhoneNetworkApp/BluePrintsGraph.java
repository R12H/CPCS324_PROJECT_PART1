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
package PhoneNetworkApp;

import GraphFramework.*;
import java.io.*;

public class BluePrintsGraph extends Graph {
    
    public int labelNo = 0;
    
    public BluePrintsGraph(){
        super();
    }

    public BluePrintsGraph(int vertices, int edges, boolean isDigraph) {
       super(vertices, edges, isDigraph);
    }

    //----------------------------------------------------------------------------------
    
    @Override
    public void makeGraph(int reqVetices, int reqEdges) {
        super.makeGraph(reqVetices, reqEdges);
    }
    
    @Override
    public void readGraphFromFile(File file) throws FileNotFoundException {
       super.readGraphFromFile(file);

    }
    
    //----------------------------------------------------------------------------------
    
    @Override
    public Vertex createVertex(String label){
        if ( label.equals("Random"))
            return new Office("O" + ++labelNo);
        return new Office(label);
    }
    
    @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
        return new Line(source, destination, weight);
    }
    
}
