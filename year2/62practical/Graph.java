import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;



public class Graph {
	 public ArrayList<Node> adjacenyList;
	   HashMap<String,Node> NodeGraph;
	    
	    
	    public Graph() {
	        this.adjacenyList = new ArrayList<Node>();
	        NodeGraph = new HashMap<String,Node>();
	    }    
	    
	    
	    
	    public void addNodes(String node, String destination, double distance){
	        //check if Node already exists
	        Node source = getNodeOrCreate(node);
	        Node dest = getNodeOrCreate(destination);
	        //add edge to node
	        source.addEdge(dest, distance);
	        
	    }
	        
	    private Node getNodeOrCreate(String node){
	        Node v;
	        if(NodeGraph.containsKey(node)){        //If node exits get it
	            v = NodeGraph.get(node);
	        }else{
	            v = new Node(node);          //if not put a node into graph 
	            NodeGraph.put(node, v);
	            adjacenyList.add(v);         //add it to the adjacency list
	        }
	        return v;
	    }
	 
	    public Node getNodeByName(String name){
	        return NodeGraph.get(name);  
	    }
	        
	        
	        public void printAdjacencyList(){
	        	for(int i=0; i<adjacenyList.size();i++){
	        		Node v = adjacenyList.get(i);
	        	
	                System.out.println("Node: " + v.name);
	                
	                for(int j=0;j<v.OutEdges.size();j++){
	                    System.out.print(v.OutEdges.get(j).target.name + "|" + v.OutEdges.get(j).distance+"m     ");
	                }
	                System.out.println();
	            }
	        }
	        private void resetDistance(){
	            for(Node v : adjacenyList){
	                v.SP = Double.POSITIVE_INFINITY;
	            }
	        }
	        
	        public Double djksraShortestPath(Node src, Node dest){
	            //makke all distances Infinity
	            resetDistance();
	            PriorityQueue<Node> queue = new PriorityQueue<Node>();
	            //make distance 0
	            src.SP = 0.0;
	            for(Node v : adjacenyList){
	                queue.add(v);        //nodes to PriorityQ based on Distance
	            }
	     
	            Node next;
	            while(!queue.isEmpty()){
	                next = queue.poll(); //remove head
	              
	                for(Edge e : next.OutEdges){ //for every edge out of the node
	                    Double dist = next.SP + e.distance;      //distance = node shortest path + edge length
	                    if(dist < e.target.SP){   //if distance is less than target node at end of the edge SP
	                        e.target.SP = dist;  //set it to distance
	                        
	                       
	                    }
	                }
	            }
	            return dest.SP;
	        }
	        public Double djksraShortestPath(String src, String dest){
	        	 
	            return djksraShortestPath(getNodeByName(src), getNodeByName(dest));
	        }
	        
	        public static void simpleGraph(){
	            Graph graph = new Graph();
	            graph.addNodes("1","2", 10);
	            graph.addNodes("1","4", 5);
	            graph.addNodes("2","3", 1);
	            graph.addNodes("2","4", 3);
	            graph.addNodes("3","5", 6);
	            graph.addNodes("4","2", 2);
	            graph.addNodes("4","3", 9);
	            graph.addNodes("4","5", 2);
	            graph.addNodes("5","1", 7);
	            graph.addNodes("5","3", 4);
	            
	            graph.printAdjacencyList();
	            
	         for(int i =1;i<6;i++){
	            System.out.print(graph.djksraShortestPath("1", String.valueOf(i))+" ");
	        }
	        }
	         
	        public static void main(String [ ] args){
	            simpleGraph();
	         
	        }
	        
	    }
	    
	    
	    


