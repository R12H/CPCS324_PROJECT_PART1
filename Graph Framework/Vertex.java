
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
