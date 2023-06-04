/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhoneNetworkApp;
import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Raghad
 */
public  class BluePrintsGraph extends Graph{
    
    public BluePrintsGraph(){
        super();
    }

    public BluePrintsGraph(int vertices, int edges) {
       super(vertices, edges);
    }

//    /**
//     * Kruskal's Algorithm : calculate the taken time to apply kurskal's algorithm on different graph 
//     */
    public void kruskal() {
        super.kruskal();
    }

    //----------------------------------------------------------------------


    public void makeGraph(int reqVetices, int reqEdges) {
        super.makeGraph(reqVetices, reqEdges);
    }
    
    //----------------------------------------------------------------------------------

    public void readGraphFromFile(File file) throws FileNotFoundException {
       super.readGraphFromFile(file);

    }
    //-----\\
    public int getCost() {
        return super.getCost() * 5;
    }
    
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
        return new Line(source, destination, weight);
    }
    public Vertex createVertex(String label){
        return new Office(label);
    }
    
}

