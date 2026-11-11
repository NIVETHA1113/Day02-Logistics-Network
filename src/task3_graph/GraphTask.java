import java.util.*;

public class GraphTask {

    // Adjacency List
    HashMap<Integer, ArrayList<Integer>> adjList;

    // Constructor
    GraphTask() {
        adjList = new HashMap<>();
    }

    // Add a hub to the graph
    void addHub(int hub) {
        adjList.putIfAbsent(hub, new ArrayList<>());
    }

    // Add an undirected route
    void addEdge(int source, int destination) {

        adjList.get(source).add(destination);

        adjList.get(destination).add(source);
    }

    // Display the graph
    void displayGraph() {

        for (int hub : adjList.keySet()) {

            System.out.println(
                hub + " -> " + adjList.get(hub)
            );
        }
    }

    // Breadth First Search
    void BFS(int start) {

        // Track visited hubs
        HashSet<Integer> visited = new HashSet<>();

        // Create Queue
        Queue<Integer> queue = new LinkedList<>();

        // Add starting hub
        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            // Remove first hub
            int current = queue.poll();

            System.out.print(current + " ");

            // Visit neighbouring hubs
            for (int neighbour : adjList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    void DFS(int current, HashSet<Integer> visited) {

        // Mark current hub as visited
        visited.add(current);

        // Print current hub
        System.out.print(current + " ");

        // Visit neighbouring hubs
        for (int neighbour : adjList.get(current)) {

            if (!visited.contains(neighbour)) {

                DFS(neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {

        GraphTask graph = new GraphTask();

        // Create 10 hubs
        int[] hubs = {
            10, 20, 30, 40, 50,
            60, 70, 80, 90, 100
        };

        for (int hub : hubs) {
            graph.addHub(hub);
        }

        // Add routes
        graph.addEdge(10, 20);
        graph.addEdge(10, 50);
        graph.addEdge(20, 30);
        graph.addEdge(20, 40);
        graph.addEdge(30, 40);
        graph.addEdge(50, 60);
        graph.addEdge(60, 70);
        graph.addEdge(70, 80);
        graph.addEdge(70, 90);
        graph.addEdge(90, 100);

        // Display adjacency list
        graph.displayGraph();
        System.out.println("\nStarting BFS:");

graph.BFS(10);
System.out.println("\nStarting DFS:");

HashSet<Integer> visited = new HashSet<>();

graph.DFS(10, visited);
    }
}
