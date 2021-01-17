package data_structures.graph;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        List<List<Integer>> graph=new ArrayList<>();

        graph.add(new ArrayList<>(Arrays.asList(1,2,3)));// 0 is connected to 1,2,3
        graph.add(new ArrayList<>());// 1 is not connected to any node or 1 is seek node
        graph.add(new ArrayList<>(Collections.singletonList(4)));// 2 is connected to 4
        graph.add(new ArrayList<>());// 3 is not connected to any node or 3 is seek node
        graph.add(new ArrayList<>());// 4 is not connected to any node or 4 is seek node

        System.out.println(new DFSOfGraph().dfsOfGraph(5, graph));
    }
}
class DFSOfGraph {
    private  boolean[] isVisited;
    public ArrayList<Integer> dfsOfGraph(int V, List<List<Integer>> adj){
        ArrayList<Integer> res=new ArrayList<>();
        isVisited=new boolean[V];
        dfs(0,adj,res);// Assuming 0 is start vertex
        return res;
    }
    private void dfs(int v, List<List<Integer>> adj,ArrayList<Integer> res){
        isVisited[v]=true;
        res.add(v);
        int n=adj.get(v).size();
        for(int i=0;i<n;i++){
            if(!isVisited[adj.get(v).get(i)]){
                dfs(adj.get(v).get(i),adj,res);
            }
        }
    }
}