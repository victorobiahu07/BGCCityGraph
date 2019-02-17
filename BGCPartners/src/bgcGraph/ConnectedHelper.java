package bgcGraph;

import java.io.*;
import java.util.*;

public class ConnectedHelper
{
	private int V;   // represents number of vertices
	private LinkedList<Integer> adj[];  // The necessary adjacency List
	private HashMap<String, Integer> nameVertice;

	//Constructor
	public ConnectedHelper(String[] cities)
	{

		V = cities.length;
		adj = new LinkedList[V];
		nameVertice = new HashMap<String, Integer>();
		for (int i=0; i<V; ++i){
			adj[i] = new LinkedList();
			nameVertice.put(cities[i], i);
		}

	}

	//method that adds an edge to a graph with the start and end points.
	//Adding two edges as it is an undirected graph
	public void addEdge(String city1, String city2)
	{
		int vertice1 = nameVertice.get(city1);
		int vertice2 = nameVertice.get(city2);
		adj[vertice1].add(vertice2);
		adj[vertice2].add(vertice1);
	}

	//prints BFS traversal from a start node to an end node
	public boolean isConnected(String startCity, String endCity)
	{
		int start = nameVertice.get(startCity);
		int end = nameVertice.get(endCity);

		LinkedList<Integer>temp;
		boolean visited[] = new boolean[V]; // marked as univisited from the start
		LinkedList<Integer> queue = new LinkedList<Integer>();//queue for BFS

		// Mark the current node as visited and enqueue it
		visited[start]=true;
		queue.add(start);

		// 'i' will be used to get all adjacent vertices of a vertex
		Iterator<Integer> i;
		while (queue.size()!=0)
		{
			//Dequeue a vertex from queue and print it
			start = queue.poll();
			int n;
			i = adj[start].listIterator();

			// Get all adj vertices of the dequeued vertex start, if adj is unvisited then mark as visited and enqueue.
			while (i.hasNext())
			{
				n = i.next();
				// If this adjacent node is the destination node,return true else continue BFS
				if (n==end)
					return true;
				if (!visited[n]) 
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		// If BFS is complete without visited end
		return false;
	}
}