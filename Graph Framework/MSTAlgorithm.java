
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
