
package PhoneNetworkApp;
import GraphFramework.Edge;
import GraphFramework.Vertex;
import java.util.LinkedList;
/**
 *
 * @author Raghad
 */
public class Office extends Vertex{
    private String label;

    
    public Office(){ 
        super();
    }
    
    public Office(String label) {
        super(label);
    }
    
    public void setLabel(String label) {
        this.label = ("O" +  label);
    }
    

    public void displayInfo() {
        System.out.print("Offic No. " + (char)(65 + Integer.parseInt(super.getLabel())));
    }
    
}
