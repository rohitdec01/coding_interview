package amazon.graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
    Clone an Undirected Graph
 */
public class CloneUnDirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");

        Queue<GraphNode> q = new LinkedList<GraphNode>();
        HashMap<GraphNode, Boolean> visit = new HashMap<GraphNode, Boolean>();
        graph.bfs(source, q, visit);
        GraphNode newSource = graph.cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");

        Queue<GraphNode> q1 = new LinkedList<GraphNode>();
        HashMap<GraphNode, Boolean> visit1 = new HashMap<GraphNode, Boolean>();
    }
}
