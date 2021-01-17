package data_structures.graph;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        List<List<Integer>> adj=new MakeGraph().getGraph(
                new int[][]{
                        {0,1},// Indicates 0 is connected to 1
                        {0,2},// Indicates 0 is connected to 2
                        {0,3},// Indicates 0 is connected to 3
                        {2,4} // Indicates 2 is connected to 4
                },5
        );
        System.out.println(new DFSOfGraph().dfsOfGraph(5,adj));
        System.out.println(new BFSOfGraph().bfsOfGraph(5,adj));
    }
}
class MakeGraph{
    public List<List<Integer>> getGraph(int[][] edges,int numberOfVertex){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numberOfVertex;i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }
    public Map<Integer,ArrayList<Integer>> getGraphByMap(int[][] edges,int numberOfVertex){
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<numberOfVertex;i++){
            adj.put(i,new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }
}