
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
        //return "Office No. "+ this.source.getLabel()+" - " + "Office No."+ this.target.getLabel() + " : line length: "+ weight;
        System.out.print(" line length: "+ weight);
    }
    
}
