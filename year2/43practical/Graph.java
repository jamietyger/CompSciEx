import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {
 
    public ArrayList<Vertex> adjacenyList;
    HashMap<String, Vertex> vertexMap;
    private double weight;                      // weight of MST
 
    public Graph() {
        this.adjacenyList = new ArrayList<Vertex>();
        vertexMap = new HashMap<String, Vertex>();
    }
 
    public void addNodes(String vertex, String destination, double distance){
        //check if vertex already exists
        Vertex src = getNodeOrCreate(vertex);
        Vertex dest = getNodeOrCreate(destination);
        //add edge to vertex
        src.addEdge(dest, distance);
    }
 
    private Vertex getNodeOrCreate(String node){
        Vertex v;
        if(vertexMap.containsKey(node)){
            v = vertexMap.get(node);
        }else{
            v = new Vertex(node);
            vertexMap.put(node, v);
            adjacenyList.add(v);
        }
        return v;
    }
 
    public Vertex getVertexByName(String name){
        return vertexMap.get(name);
    }
 
    public void printAdjacencyList(){
        for(Vertex v : adjacenyList){
            System.out.print("Vertex: " + v.name);
            for(Edge e : v.adjacentEdges){
                System.out.print(" " + e.destination.name + "/" + e.weight);
            }
            System.out.println();
        }
    }
 
    //algorithms
 
 
 public void MSTPrim(){
	 
	 getVertexByName("SFO").setKey(0.0);
	 Vertex start = new Vertex("start");
	 getVertexByName("SFO").setParent(start);
	 PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
    //insert Vertex into Q
     for(Vertex v : adjacenyList){
         queue.add(v);
     }
     
     while(queue.isEmpty()==false){
    	
    	 
    	 
    	 Vertex	next = queue.poll(); //extract min
    	 
    	 for(Edge e : next.adjacentEdges){
    		 
    		 if(queue.contains(e.destination)&&(e.weight<e.destination.key)){
    			 queue.remove(e.destination);
    			 e.destination.setKey(e.weight);
    			 e.destination.setParent(next);
    			 queue.add(e.destination);
    		 }
    		 
    		
    	 }
    	
    	 
    	 
    	 
    	 
    	 
     }
     
     printParents();
		      
	 
 }
 
 public void printParents(){
	 int sum=0;
     for(Vertex v : adjacenyList){
    	 if(v.getParent()==null){
    		 v.parent= new Vertex("none");
    	 }
         //System.out.print("Vertex: " + v.name +" Parent:"+v.getParent().name+" Key:"+v.getKey());
         sum+=v.getKey();
         //System.out.println();
     }
     System.out.println("MST Length:"+sum);
 }
   
 
    public Double djksraShortestPath(Vertex src, Vertex dest){
        //reset mins
        resetMins();
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        //init all edges as infinity
        src.minDistance = 0.0;
        for(Vertex v : adjacenyList){
            queue.add(v);
        }
 
        Vertex next;
        while(!queue.isEmpty()){
            next = queue.poll(); //extract min
          
            for(Edge e : next.adjacentEdges){
                Double dist = next.minDistance + e.weight;
                if(dist < e.destination.minDistance){
                    e.destination.minDistance = dist;
                    
                   
                }
            }
        }
        return dest.minDistance;
    }
    public Double djksraShortestPath(String src, String dest){
 
        return djksraShortestPath(getVertexByName(src), getVertexByName(dest));
    }
 
    private void resetMins(){
        for(Vertex v : adjacenyList){
            v.minDistance = Double.POSITIVE_INFINITY;
        }
    }



 
public static void simpleGraph(){
    Graph graph = new Graph();
 
   
    String [] information = new String[3];
    try {
   BufferedReader br = new BufferedReader(new FileReader("/export/home/notes/ds/airlineroutes.dot"));///export/home/notes/ds/airlineroutes.dot"


String sCurrentLine;
sCurrentLine = br.readLine();


for(int i =0; i<18;i++){
	sCurrentLine = br.readLine();
	
	
sCurrentLine=sCurrentLine.replaceAll("\\s","").replaceAll("\\[", "").replaceAll("\\]","").replaceAll("label", "").replaceAll("--", " ").replaceAll("=", " ").replaceAll(";", "");

information=sCurrentLine.split(" ");

System.out.println(sCurrentLine);
graph.addNodes(information[0],information[1], Double.parseDouble(information[2]));
graph.addNodes(information[1],information[0], Double.parseDouble(information[2]));




}
br.close();


    }
    
    
catch (IOException e) {
e.printStackTrace();
}
    
    
    graph.MSTPrim();
    
}
 
public static void main(String [ ] args){
    simpleGraph();
 
}
}
