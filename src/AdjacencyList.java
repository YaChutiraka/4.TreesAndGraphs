// Thank you for the code from http://theoryofprogramming.com/adjacency-list-in-java/
import java.util.LinkedList;
import javafx.util.Pair;

public class AdjacencyList {
	private final LinkedList<Pair<Integer, Integer>>[] adjacencyList;
	
	public AdjacencyList(int vertices){
		adjacencyList=new LinkedList[vertices];
		// TODO adjacencyList = (LinkedList< Pair<Integer, Integer> >[]) new LinkedList[vertices];
		
		for(int i=0; i<adjacencyList.length; i++){
			adjacencyList[i]=new LinkedList<Pair<Integer, Integer>>();
		}
	}
	
	public void addEdge(int startVertex, int endVertext, int weight){
		adjacencyList[startVertex].add(new Pair<>(endVertext, weight));
	}
	
	public int getNumberOfVertices(){
		return adjacencyList.length;
	}
	
	public int getNumberOfEdgestFromVertext(int startVertext){
		return adjacencyList[startVertext].size();
	}
	
	public LinkedList<Pair<Integer, Integer>> getEdgesFromVertex(int startVertex){
		LinkedList<Pair<Integer, Integer>> edgeList=new LinkedList(adjacencyList[startVertex]);
				//TODO LinkedList< Pair<Integer, Integer> > edgeList = (LinkedList< Pair<Integer, Integer> >) new LinkedList(adjacencyList[startVertex]);
		return edgeList;
	}
	
	public boolean removeEdge(int startVertex, Pair<Integer, Integer> edge){
		return adjacencyList[startVertex].remove(edge);
	}
	
	public void printAdjacencyList(){
		//TODO
	}
	
	//Test
	public static void main(String[] args){
		
	}
}
