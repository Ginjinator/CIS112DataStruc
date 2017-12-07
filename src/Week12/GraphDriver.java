package Week12;

import ch10.graphs.*;

public class GraphDriver {
    public static void main (String [] args){
        System.out.println("Creating Graph:");
        WeightedGraphHW<String> graph = new WeightedGraphHW<String>();
        String s0 = new String("Atlanta   ");
        String s1 = new String("Austin    ");
        String s2 = new String("Chicago   ");
        String s3 = new String("Dallas    ");
        String s4 = new String("Denver    ");
        String s5 = new String("Houston   ");
        String s6 = new String("Washington");

        graph.addVertex(s0);
        graph.addVertex(s1);
        graph.addVertex(s2);
        graph.addVertex(s3);
        graph.addVertex(s4);
        graph.addVertex(s5);
        graph.addVertex(s6);

        graph.addEdge(s0, s5, 800);
        graph.addEdge(s0, s6, 600);
        graph.addEdge(s1, s3, 200);
        graph.addEdge(s1, s5, 160);
        graph.addEdge(s2, s4, 1000);
        graph.addEdge(s3, s1, 200);
        graph.addEdge(s3, s2, 900);
        graph.addEdge(s3, s4, 780);
        graph.addEdge(s4, s0, 1400);
        graph.addEdge(s4, s2, 1000);
        graph.addEdge(s5, s0, 800);
        graph.addEdge(s6, s0, 600);
        //graph.addEdge(s6, s3, 1300);

        //Question 20 p.615
        System.out.println(graph.connects(s6, s3));
        //Question 42 p.618
        System.out.println(graph.minEdges(s1, s0));
    }
}