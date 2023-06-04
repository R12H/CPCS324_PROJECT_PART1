package GraphFramework;

import java.util.*;

public class Vertex {
    
    String label;
    boolean isVisited;
    LinkedList<Edge> adjList;

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
    
    public String displayInfo(LinkedList<Vertex> visited) {
        String info = "";
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited.contains(   adjList.get(i).getTarget() ))
                info +=adjList.get(i).displayInfo() + "\n";
            
            
        }
        
        return info;
        
    }
    
    
    
    
}
