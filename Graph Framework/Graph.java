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

import java.io.*;
import java.util.*;

public class Graph {
    
    int veticesNo;
    int edgeNo;
    boolean isDigraph = false;
    LinkedList<Vertex> vertices;
    
    //----------------------------------------------------------------------------------

    public Graph() {
        this.veticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
    }

    //----------------------------------------------------------------------------------
    
    public Graph(int veticesNo, int edgeNo, boolean isDigraph) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
    }
    
    //----------------------------------------------------------------------------------

    public void makeGraph(int reqVetices, int reqEdges) {

        vertices = new LinkedList<>();

        Random random = new Random();
        
        //Create first vertex so we can use (i) and (i+1) for each round
        vertices.add(createVertex("" + 0));
        veticesNo++;

        for (int i = 1; i < reqVetices; i++) {
            
            vertices.add(createVertex("" + i));

            veticesNo++;

            int weight = random.nextInt(10) + 1;

            addEdge(vertices.get(i - 1), vertices.get(i), weight);
            this.edgeNo++;

        }

        //determine the reamaining edges so we create more that connects old vertexes
        int remEdges = reqEdges - this.edgeNo;

        for (int i = 0; i < remEdges; i++) {

            Vertex srcVer = vertices.get(random.nextInt(reqVetices));
            Vertex desVer = vertices.get(random.nextInt(reqVetices));

            boolean isConnected = isConnected(srcVer, desVer, srcVer.getAdjList());
            
            //Be careful it won't create a self loop nor dublicate one
            //or else break the loop and decrease the i
            if (srcVer == desVer || isConnected) {
                i -= 1;
                continue;
            }

            int weight = random.nextInt(10) + 1;

            addEdge(srcVer, desVer, weight);
            this.edgeNo++;

        }

    }
    
    //----------------------   Method to check if there's edge   -----------------------

    public boolean isConnected(Vertex src, Vertex des, LinkedList<Edge> srcEdges) {

        for (int i = 0; i < srcEdges.size(); i++) {
            if (srcEdges.get(i).getTarget() == des) {
                return true;
            }
        }
        return false;
    }
    
    //----------------------------------------------------------------------------------

    public void readGraphFromFile(File file) throws FileNotFoundException {

        Scanner input = new Scanner(file);

        //To shift the pointer
        String start = input.next();
        
        //Assaign the values
        this.vertices = new LinkedList<>();
        this.isDigraph = input.nextInt() == 1 ? true : false;
        this.veticesNo = input.nextInt();
        this.edgeNo = input.nextInt();

        while (input.hasNext()) {
            
            //Create objects Inititially in case it's a new vertex
            Vertex srcVer = createVertex(input.next());
            Vertex desVer = createVertex(input.next());

            if (vertices.isEmpty()) {
                vertices.add(srcVer);
                vertices.add(desVer);
                
            } else {
                
                //To search for the two vertex
                boolean found = false;
                
                for (int i = 0; i < vertices.size(); i++) {
                    
                    // If the label of the vertex with index (i) == the new vertex label
                    if (vertices.get(i).getLabel().equals(srcVer.getLabel())) {
                        
                        //Assign the founded vertex to the one we creeate earlier
                        srcVer = vertices.get(i);
                        found = true;
                        //Break the loop
                        continue;
                    }
                }

                if (!found) {
                    vertices.add(srcVer);
                }
                
                
                //doing the same process for the target vertex
                found = false;

                for (int i = 0; i < vertices.size(); i++) {
                    if (vertices.get(i).getLabel().equals(desVer.getLabel())) {
                        desVer = vertices.get(i);
                        found = true;
                        continue;
                    }
                }
                if (!found) {
                    vertices.add(desVer);
                }
            }

            addEdge(srcVer, desVer, input.nextInt());

        }

    }
    
    //----------------------------------------------------------------------------------

    public void addEdge(Vertex v, Vertex u, int w) {
        //v = sourse
        //u = taget
        //w = weight
        v.adjList.add(createEdge(v, u, w));
        //in case the graph's directed increase edges by one

        //in case it's undirected add the edge to the target and increase edges by two
        if (!isDigraph) {
            u.adjList.add(createEdge(u, v, w));
        }

    }
    
    //-------------  Method to return a list with the edges(for kruskal)   -------------

    public  Edge[] getGraphEdges() {
        
        Edge[] allEdges = new Edge[edgeNo];
        int index = 0;
        LinkedList<Vertex> visited = new LinkedList<>();
        
        for (int i = 0; i <vertices.size(); i++) {
            for (int j = 0; j < vertices.get(i).adjList.size(); j++) {
            if ( !visited.contains(   vertices.get(i).adjList.get(j).getTarget()) ){
                allEdges[index] = (vertices.get(i).adjList.get(j));
                index++;
                visited.add(vertices.get(i));
                }

            }
        }
        return allEdges;
    }

    
    //----------------------------------------------------------------------------------

    public Vertex createVertex(String lebel) {
        return null;
        
    }

    public Edge createEdge(Vertex v, Vertex u, int weight) {
        return null;
    }
    
}
