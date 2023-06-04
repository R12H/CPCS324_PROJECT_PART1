package GraphFramework;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author najd
 */
public abstract class Graph {


    boolean isDigraph;
   /*-------------------------------*/
    int totalVetices;
    int totalEdge;
    int veticesNo;
    int edgeNo;

    
    int cost;
    LinkedList<Vertex> vertices;
    /**
     * a linked list that save every vertex adjacent 
     */
    LinkedList<Edge>[] adjacencylist;
    
    public Graph(){
        this.totalEdge = 0;
        this.totalVetices = 0;
        this.isDigraph = false;
    }

    public Graph(int vertices, int edges) {
        this.totalVetices = vertices;
        this.totalEdge = edges;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    
    public void addEdge(Vertex source, Vertex destination, int weight) {
        // convert label from string to int to use it as an index in edge list
        int sourceIndex = Integer.parseInt(source.label);
        adjacencylist[sourceIndex].addFirst(createEdge(source, destination, weight));
        if (this.isDigraph == true) {
        //in case the graph's directed increase edges by one
            this.edgeNo++;
        }
        //for undirected graph
        else {
           // convert label from string to int to use it as an index in edge list
           int targetIndex = Integer.parseInt(destination.label); 
        adjacencylist[targetIndex].addFirst(createEdge(destination, source, weight));
        //in case the graph's undirected increase edges by two
        this.edgeNo = this.edgeNo + 2;
        }
    }

//    /**
//     * Kruskal's Algorithm : calculate the taken time to apply kurskal's algorithm on different graph 
//     */
    public void kruskal() {

        LinkedList<Edge>[] allEdges = adjacencylist.clone(); 
        PriorityQueue<Edge> priorityQueueVar = new PriorityQueue<>(totalEdge, Comparator.comparingInt(o -> o.weight));
        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i < allEdges.length; i++) {
            for (int j = 0; j < allEdges[i].size(); j++) {
                priorityQueueVar.add(allEdges[i].get(j));
                
            }
        }
        //create a parent []
        int[] parent = new int[totalVetices];

        //makeset
        makeSet(parent);

        LinkedList<Edge> MinSpanTree = new LinkedList<>();

        //process vertices - 1 edges
        int index = 0;
        while (index < totalVetices - 1 && !priorityQueueVar.isEmpty()) {
            Edge edge = priorityQueueVar.remove();
            //check if adding this edge creates a cycle
            
            //convert edge source lable to index
            int sourceIndex = Integer.parseInt(edge.source.getLabel());
            int targetIndex = Integer.parseInt(edge.target.getLabel());
         
            int x_set = find(parent, sourceIndex);
            int y_set = find(parent, targetIndex);

            if (x_set == y_set) {
                //ignore, will create cycle
            } else {
                //add it to our final result
                MinSpanTree.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }
        
        //print the total time consumed by the algorithm
        displayInfo(MinSpanTree);
        this.cost(MinSpanTree);
        System.out.println("Minimum Spanning Tree Cost = " +  cost(MinSpanTree));
        
        
    }


  
    public void makeSet(int[] parent) {
        for (int i = 0; i < totalVetices; i++) {
            parent[i] = i;
        }
    }

   
    public int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        };
        return vertex;
    }

   public void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    } 

   private void displayInfo(LinkedList<Edge> edgeList) {
        int cost = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            edgeList.get(i).source.displayInfo();
            System.out.print(" - ");
            edgeList.get(i).target.displayInfo();
            System.out.print(" : ");
            edgeList.get(i).displayInfo();
            System.out.println();
        }
    }
   
    public int cost(LinkedList<Edge> edgeList) {
        int cost = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            cost += edge.weight;
        }
        return cost;
    }

    //----------------------------------------------------------------------


    public void makeGraph(int reqVetices, int reqEdges) {
        // instance of Random class
        Random random = new Random();
        // ensure that all vertices are connected
        for (int i = 0; i < totalVetices - 1; i++) {
             // generate random weights in range 0 to 20
            int RandomNum = random.nextInt(20) + 1;
            addEdge(createVertex(i + ""), createVertex((i + 1) + ""), RandomNum);
            this.edgeNo++;

        }

        // generate random graph with the remaining edges
        int remaning = totalEdge - (totalVetices - 1);

        for (int i = 0; i < remaning; i++) {
            Vertex source = createVertex(random.nextInt(totalVetices) + "");
            Vertex Destination = createVertex(random.nextInt(totalVetices) + "");
            if (Destination == source || isConnected(source, Destination, adjacencylist)) { // to avoid self loops and duplicate edges
                i--;
                continue;
            }
            // generate random weights in range 0 to 20
            int weight = random.nextInt(20) + 1;
            // add edge to the graph
            addEdge(source, Destination, weight);
            this.edgeNo++;
        }
            

        }


   //----------------------   Method to check if there's edge   -----------------------

    public boolean isConnected(Vertex src, Vertex des, LinkedList<Edge>[] srcEdges) {
        for (LinkedList<Edge> i : srcEdges) {
            for (Edge edge : i) {
                if ((edge.parent == src && edge.target == des) || (edge.parent == des && edge.target == src)) {
                    return true;
            }
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
        this.totalVetices = input.nextInt();
        this.totalEdge = input.nextInt();

        LinkedList<Edge>[] list  = new LinkedList[totalVetices];
        for (int i = 0; i < totalVetices; i++) {
            list[i] = new LinkedList<>();
        }
        //add input edge to adge list
        this.adjacencylist = list.clone();
        
        while (input.hasNext()) {
            
            //Create objects Inititially in case it's a new vertex
            String s = input.next();
            //convert the char to int than to string
            s = "" + (s.charAt(0) - 65);
            Vertex srcVer = createVertex(s);
            
            s = input.next();
            //convert the char to int than to string
            s = "" + (s.charAt(0) - 65);
            Vertex desVer = createVertex(s);

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

                //doing the same process for the dtarget vertex
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
            kruskal();

       


        }

    }
    
    public int getCost() {
        return cost;
    }
    
    public abstract Vertex createVertex(String label);

    public abstract Edge createEdge(Vertex source, Vertex destination, int weight);
    
}
