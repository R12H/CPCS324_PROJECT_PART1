
package GraphFramework;




public class Edge {
    
    Vertex parent;
    Vertex source;
    Vertex target;
    int weight;

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
    
    public String displayInfo() {
        return "Office No. "+ source.getLabel() + " – Office No. "+target.getLabel() + " : line length: "+ weight;
        
    }
    
    
    
}
