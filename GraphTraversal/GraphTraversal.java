import java.util.*;
import java.io.*;

public class GraphTraversal
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
	
	public static void BFSTraverse(String node, HashMap<String, LinkedList<String>> graph) {
		Queue<String> q = new LinkedList<String>();
		LinkedList<String> neighbors = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		
		if(node == null) return;
		
		neighbors = graph.get(node);
		
		q.add(node);
		q.addAll(neighbors);
		visited.add(node);
		
		System.out.print(node + "  ");
		
		while(!q.isEmpty()) {
			String n = q.remove();
			LinkedList<String> child = null;
			
			if(!visited.contains(n)) {
				child = graph.get(n);
				System.out.print(n + "  ");
				q.addAll(child);
			}
			
			visited.add(n);
		}
		
		System.out.println();
		//System.out.println("Graph neighbors: " + graph.get(node));
	}
	
	public static void DFSTraverse(String node, HashMap<String, LinkedList<String>> graph) {
		Stack<String> s = new Stack<String>();
		LinkedList<String> neighbors = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		
		if(node == null) return;
		
		neighbors = graph.get(node);
		
		s.push(node);
		s.addAll(neighbors);
		visited.add(node);
		
		System.out.print(node + "  ");
		
		while(!s.isEmpty()) {
			String n = s.pop();
			LinkedList<String> child = null;
			
			if(!visited.contains(n)) {
				child = graph.get(n);
				System.out.print(n + "  ");
				s.addAll(child);
			}
			
			visited.add(n);
		}
		
		System.out.println();
		//System.out.println("Graph neighbors: " + graph.get(node));
	}

	
	public static void main(String[] args)
	{
		// Construct the graph from a text file
		HashMap<String, LinkedList<String>> graph = CreateGraphFromFile("nodes.txt");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the DFS and BFS traversal tool!");
		
		while(true) {
			try {
				System.out.print("DFS or BFS? ");
				String choice = sc.nextLine().toUpperCase();
				
				System.out.print("Enter the starting node: ");
				String node = sc.nextLine().toUpperCase();
				
				if(choice.equals("DFS")) {
					DFSTraverse(node, graph);
				} else if(choice.equals("BFS")) {
					BFSTraverse(node, graph);
				} else {
					System.out.println("Not a valid choice");
				}
				
				
			} catch(NullPointerException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}