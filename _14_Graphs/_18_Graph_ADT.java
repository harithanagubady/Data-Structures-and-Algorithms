import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _18_Graph_ADT {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        System.out.print("Vertices: ");
        for (int vertex : graph.getVertices()) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getV1() + ", " + edge.getV2() + ") ");
        }
        System.out.println();

        System.out.print("Neighbors of vertex 1: ");
        for (int neighbor : graph.getNeighbors(1)) {
            System.out.print(neighbor + " ");
        }
        System.out.println();

        System.out.println("Is vertex 1 adjacent to vertex 2? " + graph.isAdjacent(1, 2));

        graph.removeEdge(1, 2);
        graph.removeVertex(3);

        System.out.println("After removing some edges and vertices:");

        System.out.print("Vertices: ");
        for (int vertex : graph.getVertices()) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getV1() + ", " + edge.getV2() + ") ");
        }
        System.out.println();
        System.out.println("Number of vertices: " + graph.getVertexCount());
        System.out.println("Number of edges: " + graph.getEdgeCount());
    }
}


class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex (int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void removeVertex (int vertex) {
        adjacencyList.remove(vertex);
        //remove all edges to vertex
        for (List<Integer> edges : adjacencyList.values()) {
            edges.removeIf(v -> v == vertex);
        }
    }

    public void addEdge (int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            return;
        }
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge (int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            return;
        }
        adjacencyList.get(vertex1).removeIf(v -> v == vertex2);
        adjacencyList.get(vertex2).removeIf(v -> v == vertex1);
    }

    public List<Integer> getVertices () {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public List<Pair<Integer, Integer>> getEdges () {
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : adjacencyList.entrySet()) {
            int v1 = e.getKey();
            for (int v2 : e.getValue()) {
                edges.add(new Pair<>(v1, v2));
            }
        }
        return edges;
    }

    public List<Integer> getNeighbors(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return null;
        }
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public boolean isAdjacent(int vertex1, int vertex2) {
        return adjacencyList.getOrDefault(vertex1, new ArrayList<>()).contains(vertex2);
    }

    public int getVertexCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> edges : adjacencyList.values()) {
            count += edges.size();
        }
        return count/2;
    }
}

class Pair<T, U> {
    private T v1;
    private U v2;

    public Pair (T v1, U v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public T getV1() {
        return v1;
    }

    public U getV2() {
        return v2;
    }
}