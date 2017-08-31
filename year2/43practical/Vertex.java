import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
 
    public String name;
    public ArrayList<Edge> adjacentEdges; //list of outgoing edges
    public Double minDistance = Double.POSITIVE_INFINITY; //used for SSP
    public Vertex parent;
    public Double key = Double.POSITIVE_INFINITY;
    public Vertex(String name) {
        this.name = name;
        this.adjacentEdges = new ArrayList<Edge>();
        this.parent=null;
    }
 
    public void addEdge(Vertex dest, double cost){
        adjacentEdges.add(new Edge(dest, cost));
    }
 
    @Override
    public int compareTo(Vertex o) {
        return (int)(key - o.key); //to be used for heaps
    }
    public void setKey(double newnum){
    	key = newnum;
    }
    
    public Double getKey(){
    	return key;
    }
    
    public Vertex getParent(){
    	return parent;
    }
    public void setParent(Vertex newP){
    	parent = newP;
    }
}