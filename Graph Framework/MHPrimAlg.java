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

public class MHPrimAlg extends MSTAlgorithm {

    int cost;

    public MHPrimAlg(Graph graph) {
        super(graph);
    }

    // Prim's algorithm implementation using Min-heap
    public void mhPrim() {
        

        // Create a ------------ (Min-heap) to store edges
        MinHeap minHeap = new MinHeap(super.gragh.edgeNo);

        // Create a boolean array to track visited vertices
        boolean[] visited = new boolean[super.gragh.veticesNo];
        
        LinkedList<Edge> MinSpanTree = new LinkedList<>();
        
        // Start from the first vertex (assumed to be the source)
        visited[0] = true;


        //add all the edges to array 
        //add all edges of first vertex in minHeap
        for (Edge edge: super.gragh.vertices.get(0).adjList) {
            minHeap.add(edge);
        }
        
        visited[0] = true;

        // Process vertices until the priority queue is empty
        while (minHeap.peek() != null) {
                // remove the minimum edge from minHeap
            Edge edge = minHeap.poll();
            
            int srcIndex = super.gragh.vertices.indexOf(edge.getSource());
            int tarIndex = super.gragh.vertices.indexOf(edge.getTarget());

            if (visited[srcIndex] && visited[tarIndex] ) {
                continue;
            }

            MinSpanTree.add(edge);
            this.cost += edge.getWeight();

            // visited[source] = true
            visited[srcIndex] = true;

            for (Edge e : super.gragh.vertices.get(tarIndex).getAdjList()) {
                int eIndex = super.gragh.vertices.indexOf(e.getTarget());
                if (!visited[eIndex]) {
                    
                    minHeap.add(e);
                }
            }

            visited[tarIndex] = true;
        }
        setMSTResultList(MinSpanTree);
    }
    
  public int getCost() {
        return cost;
    }
    
    @Override
    public void displayResultingMST() {
        super.displayResultingMST();

    }
}
