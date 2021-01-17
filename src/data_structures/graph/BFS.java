package data_structures.graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> graph=new ArrayList<>();

        graph.add(new ArrayList<>(Arrays.asList(1,2,3)));// 0 is connected to 1,2,3
        graph.add(new ArrayList<>());// 1 is not connected to any node or 1 is seek node
        graph.add(new ArrayList<>(Collections.singletonList(4)));// 2 is connected to 4
        graph.add(new ArrayList<>());// 3 is not connected to any node or 3 is seek node
        graph.add(new ArrayList<>());// 4 is not connected to any node or 4 is seek node

        System.out.println(new BFSOfGraph().bfsOfGraph(5, graph));
    }
}
class BFSOfGraph {
    public ArrayList<Integer> bfsOfGraph(int V, List<List<Integer>> adj){
        ArrayList<Integer> res=new ArrayList<>();

        Queue<Integer> q=new LinkedList<>();
        boolean[] isVisited=new boolean[V];

        q.offer(0);// Assuming 0 is start vertex
        while(!q.isEmpty()){
            int vertex=q.poll();

            if(!isVisited[vertex]) {
                res.add(vertex);

                isVisited[vertex] = true;

                int n = adj.get(vertex).size();
                for (int i = 0; i < n; i++) {
                    if (!isVisited[adj.get(vertex).get(i)]) {
                        q.offer(adj.get(vertex).get(i));
                    }
                }
            }
        }
        return res;
    }
}