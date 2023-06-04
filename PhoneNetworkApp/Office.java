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

public class Office extends Vertex {
    
   private String label;
    
    public Office(){ 
        super();
    }
    
    //----------------------------------------------------------------------------------
    public Office(String label) {
        super(label);
    }
    
    //----------------------------------------------------------------------------------
    public void setLabel(String label) {
        this.label = ("O" +  label);
    }
    
    //----------------------------------------------------------------------------------
    @Override
    public void displayInfo() {
            System.out.print("Offic No. " + super.getLabel());

    }
}
