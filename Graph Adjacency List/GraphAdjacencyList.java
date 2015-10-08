import java.util.*;
import java.io.*;

public class GraphAdjacencyList
{
	public static HashMap<String, LinkedList<String>> CreateGraphFromFile(String filename) {
		// Initialize variables
		HashMap<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>();
		LinkedList<String> list = new LinkedList<String>();
		String node = "";
		
		// In case any issues arise with reading the file, catch them and print the message
		try{
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			// Do things until EOF (null)
			while( ((node = br.readLine()) != null) ) {
				String[] split = node.split(",");
				for(int i = 1; i < split.length; i++){
					list.add(split[i]);
				}
				graph.put(split[0], list);
				
				list = new LinkedList<String>();
			}
			br.close();
			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return graph;
	}
	
	public static boolean IsConnected(String x, String y, HashMap<String, LinkedList<String>> graph) {
		LinkedList<String> result = graph.get(x);
		
		for(int i = 0; i < result.size(); i++) {
			if(result.get(i).equals(y)) {
				return true;
			}
		}
		return false;
	}	
	
	public static void main(String[] args)
    {
		// Construct the graph from a text file
		HashMap<String, LinkedList<String>> graph = CreateGraphFromFile("nodes.txt");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Graph Adjacency Comparator!");
		
		while(true) {
			try {
				System.out.print("Enter the first node: ");
				String node1 = sc.nextLine().toUpperCase();
				
				System.out.print("Enter the second node: ");
				String node2 = sc.nextLine().toUpperCase();
				
				if(IsConnected(node1, node2, graph)) {
					System.out.println("Yes, they are directly connected");
				} else {
					System.out.println("No, they are not directly connected");
				}
				
			} catch(NullPointerException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}