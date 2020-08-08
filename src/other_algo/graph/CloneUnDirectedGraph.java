package other_algo.graph;


/*
    Clone an Undirected Graph
 */
public class CloneUnDirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        graph.bfs(source);
        GraphNode newSource = graph.cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        graph.bfs(newSource);
    }
}
