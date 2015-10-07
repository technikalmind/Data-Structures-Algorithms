import java.util.*;
import java.io.*;

public class GraphAdjacencyList
{
	public static HashMap<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>();
	public static void ReadFromFile() {
		try{
			File f = new File("nodes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String node = "";
			int lineNum = 0;
			LinkedList<String> list = new LinkedList<String>();
			
			while( ((node = br.readLine()) != null) ) {
				String[] split = node.split(",");
				for(int i = 1; i < split.length; i++){
					list.add(split[i]);
				}
				graph.put(split[0], list);
				
				System.out.println(graph.values());
			}
			br.close();
			fr.close();
			
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean IsConnected(String x, String y, HashMap<String, LinkedList<String>> g) {
		LinkedList<String> result = g.get(x);
		
		for(int i = 0; i < result.size(); i++) {
			if(result.get(i) == y) {
				return true;
			}
		}
		
		return false;
	}	
	
    public static void main(String[] args)
    {
		/*
		// Temporary until ReadFromFile() can be constructed
		LinkedList<String> node_A = new LinkedList<String>();
		LinkedList<String> node_B = new LinkedList<String>();
		LinkedList<String> node_C = new LinkedList<String>();
		LinkedList<String> node_E = new LinkedList<String>();
		LinkedList<String> node_F = new LinkedList<String>();
		LinkedList<String> node_K = new LinkedList<String>();
		
		// A's connections
		node_A.add("B");
		node_A.add("E");
		
		// B's connections
		node_B.add("C");
		node_B.add("A");
		node_B.add("F");
		
		// C's connections
		node_C.add("K");
		node_C.add("B");
		
		// E's connections
		node_E.add("A");
		node_E.add("F");
		
		// F's connections
		node_F.add("E");
		node_F.add("K");
		node_F.add("B");
		
		// K's connections
		node_K.add("F");
		node_K.add("C");
		
		/////////////////////
		// CONSTRUCT GRAPH //
		/////////////////////
		HashMap<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>();
		graph.put("A", node_A);
		graph.put("B", node_B);
		graph.put("C", node_C);
		graph.put("E", node_E);
		graph.put("F", node_F);
		graph.put("K", node_K);
		
		
		System.out.println(IsConnected("E", "F", graph)); // True
		System.out.println(IsConnected("A", "F", graph)); // False
		System.out.println();
		System.out.println(IsConnected("K", "C", graph));
		*/
		ReadFromFile();
		System.out.println(IsConnected("E", "F", graph)); // True
		System.out.println(IsConnected("A", "F", graph)); // False
		
		System.out.println(graph.keySet());
	}
}