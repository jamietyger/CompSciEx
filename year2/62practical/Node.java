import java.util.ArrayList;

public class Node implements Comparable<Node>{
 
    public String name;
    public ArrayList<Edge>OutEdges; //list of outgoing edges
    public Double SP = Double.POSITIVE_INFINITY; //shortest path
 
    public Node(String name) {   //Create Node
        this.name = name;
        this.OutEdges = new ArrayList<Edge>(); //Edges ArrayList
    }
 
    public void addEdge(Node dest, double cost){
        OutEdges.add(new Edge(dest, cost));  //Add Edge to ArrayList
    }
 
    @Override
    public int compareTo(Node o) {
        return (int)(SP - o.SP); //to be used for heaps
    }
    
    
}