
package GraphFramework;

import java.util.*;

public class MHPrimAlg extends MSTAlgorithm {
    
    int cost;

    public MHPrimAlg(Graph graph){
        super(graph);
    }
    
    //Prim implementation
    public void mhPrim() {
        
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        LinkedList<Edge> MinSpanTree = new LinkedList<>();
        boolean[] visited = new boolean[super.gragh.veticesNo];

        //add all edges of first vertex in minHeap
        for (Edge edge: super.gragh.vertices.get(0).adjList) {
            minHeap.add(edge);
        }

        visited[0] = true;

        while (!minHeap.isEmpty()) {
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
