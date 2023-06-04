package GraphFramework;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Arrays;
public class KruskalAlg extends MSTAlgorithm {
//    /**
//     * Kruskal's Algorithm : calculate the taken time to apply kurskal's algorithm on different graph 
//     */
    int cost;
    
    public KruskalAlg(Graph gragh){
        super(gragh);
    }
    //kruskal implementation
    public void kruskal() {

        LinkedList<Edge>[] allEdges = super.gragh.adjacencylist.clone();
        Edge [] sortArray = new Edge[super.gragh.edgeNo];
        int arrayIndex =  0;
        //add all the edges to priority queue, //sort the edges on weights
        for (LinkedList<Edge> allEdge : allEdges) {
            for (int j = 0; j < allEdge.size(); j++) {
                sortArray [arrayIndex] = allEdge.get(j);
                arrayIndex++;  
            }
        }
        Arrays.sort(sortArray, Comparator.comparing(Edge::getWeight));

        //create a parent []
        int[] parent = new int[super.gragh.totalVetices];

        //makeset
        makeSet(parent);

        LinkedList<Edge> MinSpanTree = new LinkedList<>();

        //process vertices - 1 edges
        int index = 0;
        arrayIndex =  0;
        while (index < super.gragh.totalVetices - 1 && !(arrayIndex == sortArray.length)) {
            Edge edge = sortArray [arrayIndex];
            //check if adding this edge creates a cycle
            
            //convert edge source lable to index
            int sourceIndex = Integer.parseInt(edge.source.getLabel());
            int targetIndex = Integer.parseInt(edge.target.getLabel());
         
            int x_set = find(parent, sourceIndex);
            int y_set = find(parent, targetIndex);

            if (x_set == y_set) {
                //ignore, will create cycle
            } else {
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
        for (int i = 0; i < super.gragh.totalVetices; i++) {
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
    

