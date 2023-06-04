package Cpcs324_Rq2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author najd
 */
public class Graph {

   
    int vertices;

  
    int edges;

    /**
     * a linked list that save every vertex adjacent 
     */
    LinkedList<Edge>[] adjacencylist;
    
    
    Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge);

        edge = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge); //for undirected graph

    }

//    /**
//     * Kruskal's Algorithm : calculate the taken time to apply kurskal's algorithm on different graph 
//     */
    public void kruskal() {
        // start time
        double StartTime = System.currentTimeMillis();
        LinkedList<Edge>[] allEdges = adjacencylist.clone(); 
        PriorityQueue<Edge> priorityQueueVar = new PriorityQueue<>(edges, Comparator.comparingInt(o -> o.weight));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i < allEdges.length; i++) {
            for (int j = 0; j < allEdges[i].size(); j++) {
                priorityQueueVar.add(allEdges[i].get(j));
            }
        }
        //create a parent []
        int[] parent = new int[vertices];

        //makeset
        makeSet(parent);

        LinkedList<Edge> MinSpanTree = new LinkedList<>();

        //process vertices - 1 edges
        int index = 0;
        while (index < vertices - 1 && !priorityQueueVar.isEmpty()) {
            Edge edge = priorityQueueVar.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.sourceVertex);
            int y_set = find(parent, edge.destinationVertex);

            if (x_set == y_set) {
                //ignore, will create cycle
            } else {
                //add it to our final result
                MinSpanTree.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }

        //finish time of the algorithm
        double FinishTime = System.currentTimeMillis();
        //print the total time consumed by the algorithm
        System.out.println("Total runtime of Kruskal's Algorithm: " + (FinishTime - StartTime) + " ms.");
        printGraph(MinSpanTree);
    }


  
    public void makeSet(int[] parent) {
        for (int i = 0; i < vertices; i++) {
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

    public void printGraph(LinkedList<Edge> edgeList) {
        int cost = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            cost += edge.weight;
        }
        System.out.println("Minimum Spanning Tree Cost = " + cost);
    }

    //----------------------------------------------------------------------

    public void make_graph(Graph graph) {
        // instance of Random class
        Random random = new Random();
        // ensure that all vertices are connected
        for (int i = 0; i < vertices - 1; i++) {
            int RandomNum = random.nextInt(10) + 1;
            addEdge(i, i + 1, RandomNum);

        }

        // generate random graph with the remaining edges
        int remaning = edges - (vertices - 1);

        for (int i = 0; i < remaning; i++) {
            int source = random.nextInt(graph.vertices);
            int Destination = random.nextInt(graph.vertices);
            if (Destination == source || isConnected(source, Destination, graph.adjacencylist)) { // to avoid self loops and duplicate edges
                i--;
                continue;
            }
            // generate random weights in range 0 to 20
            int weight = random.nextInt(20) + 1;
            // add edge to the graph
            addEdge(source, Destination, weight);
        }
    }

    public boolean isConnected(int Source, int Destination, LinkedList<Edge>[] allEdges) {
        for (LinkedList<Edge> i : allEdges) {
            for (Edge edge : i) {
                if ((edge.sourceVertex == Source && edge.destinationVertex == Destination) || (edge.sourceVertex == Destination && edge.destinationVertex == Source)) {
                    return true;
                }
            }
        }
        return false;
    }
}
 class ResultSet {

    /**
     * the vertex int value 
     */
    int parent;

    /**
     * the vertex int weight 
     */
    int weight;
}