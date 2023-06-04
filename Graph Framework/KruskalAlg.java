
package GraphFramework;

import java.util.*;
public class KruskalAlg extends MSTAlgorithm {
    
    int cost;
    
    public KruskalAlg(Graph gragh){
        super(gragh);
    }
    
    //kruskal implementation
    public void kruskal() {
        
        //Create array with edge to sort the edges by weight
        Edge[] sortArray = super.gragh.getGraphEdges();
        Arrays.sort(sortArray, Comparator.comparing(Edge::getWeight));

        //create a parent []
        int[] parent = new int[super.gragh.veticesNo];

        //makeset
        makeSet(parent);

        LinkedList<Edge> MinSpanTree = new LinkedList<>();

        //process vertices - 1 edges
        int index = 0;
        int arrayIndex =  0;
        
        while (index < super.gragh.veticesNo - 1 && !(arrayIndex == sortArray.length)) {
            
            Edge edge = sortArray [arrayIndex];
            
            /**convert edge source label to index
               Note that java represent 'A' character as 65 so we subtract 65 */
            int sourceIndex = (int) edge.source.getLabel().charAt(0)-65;
            int targetIndex = (int) edge.target.getLabel().charAt(0)-65;
            
            //check if adding this edge creates a cycle
            int x_set = find(parent, sourceIndex);
            int y_set = find(parent, targetIndex);
            
            if (!(x_set == y_set)) {
                
                //add it to our final result
                MinSpanTree.add(edge);
                
                //calculate the cost of minimum spanning tree
                this.cost += edge.weight;
                index++;
                union(parent, x_set, y_set);
            }
            arrayIndex++;
        }
        setMSTResultList(MinSpanTree);
    }
        
    
    public void makeSet(int[] parent) {
        for (int i = 0; i < super.gragh.veticesNo; i++) {
            parent[i] = i;
        }
    }
   
    public int find(int[] parent, int vertex) {
        
        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        }
        
        return vertex;
    }

    public void union(int[] parent, int x, int y) {
       
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    } 

    public int getCost() {
        return cost;
    }
   
    @Override
    public void setMSTResultList(LinkedList<Edge> MSTResultList) {
        super.setMSTResultList(MSTResultList);
    }
        
    public void displayResultingMST (LinkedList<Edge> edgeList){
        super.displayResultingMST();
    }
    
}
