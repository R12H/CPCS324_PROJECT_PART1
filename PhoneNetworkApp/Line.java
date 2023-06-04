/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  KruskalAlg: https://algorithms.tutorialhorizon.com/kruskals-algorithm-minimum-spanning-tree-mst-complete- java-implementation/
3)  MinHeap:  https://medium.com/@ankur.singh4012/implementing-min-heap-in-java-413d1c20f90d
4)  MHPrimAlg :  https://www.baeldung.com/java-prim-algorithm

Section:
CP1
 */
package PhoneNetworkApp;

import GraphFramework.*;

public class Line extends Edge {
    private int lLenght;

    public Line (){
        super();
        this.lLenght = 0;
    }
    
    //----------------------------------------------------------------------------------
    public Line (Vertex source, Vertex target, int weight) {
        super(source, target, weight);
        this.lLenght = weight * 5;
    }

    //----------------------------------------------------------------------------------
    public int getlLenght() {
        return lLenght;
    }
    
    //----------------------------------------------------------------------------------
    @Override
    public void displayInfo() {
        System.out.print("line length: " + lLenght); 
    }
    
}
