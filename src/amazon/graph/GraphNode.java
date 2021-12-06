package amazon.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int val;
    // A neighbour Vector which contains references to all the neighbours of a GraphNode
    List<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        neighbours = new ArrayList<>();
    }
}
