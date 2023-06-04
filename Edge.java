package Cpcs324_Rq2;

/**
 *
 * @author najd
 */
public class Edge {

    
    int sourceVertex;

   
    int destinationVertex;

  
    int weight;


    
    public Edge(int source, int destination, int weight) {
        this.sourceVertex = source;
        this.destinationVertex = destination;
        this.weight = weight;
    }

    public String toString() {
        return "source"+ sourceVertex + "-" + "destination"+destinationVertex + ": " + weight;
    }
}