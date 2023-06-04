
package PhoneNetworkApp ;

/**
 *
 * @author Raghad
 */

import GraphFramework.Edge;
import GraphFramework.Vertex;
public class Line extends Edge{
    int lLenght;

    public Line (){
        super();
        this.lLenght = 0;
    }
    
    public Line (Vertex source, Vertex target, int weight) {
        super(source, target, weight);
        this.lLenght = weight * 5;
    }

    public int getlLenght() {
        return lLenght;
    }
    public void displayInfo() {
        System.out.print("line length: " + lLenght); 
    }
}
