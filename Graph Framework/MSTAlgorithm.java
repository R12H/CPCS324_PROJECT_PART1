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
package GraphFramework;

import java.util.*;

public class MSTAlgorithm {
    
    Graph gragh;
    LinkedList<Edge> MSTResultList;
    
    public MSTAlgorithm(Graph gragh){
        this.gragh = gragh;
    }
    
    public void setMSTResultList(LinkedList<Edge> MSTResultList) {
        this.MSTResultList = MSTResultList;
    }
    
    public Graph getGragh() {
        return gragh;  
    }
    
   public void displayResultingMST() {
        for (int i = 0; i < MSTResultList.size(); i++) {
            MSTResultList.get(i).source.displayInfo();
            System.out.print(" - ");
            MSTResultList.get(i).target.displayInfo();
            System.out.print(" : ");
            MSTResultList.get(i).displayInfo();
            System.out.println();
        }
    }
    
}
