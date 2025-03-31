package org.bhaskar.graph;

import java.io.IOException;
import java.util.*;

public class GraphBasicOperation {
        public static void main(String[] args) throws IOException {

            StringBuilder str=new StringBuilder();
            str.append("bhaskar");
            Map<String,String> map =new HashMap<>();
            map.put(str.toString(),"ssss");
                ArrayList<List<Integer>> adj =
                        new ArrayList<List<Integer>>();
               // [[2,3,1] , [0], [0,4], [0], [2]]
                List<Integer> l1=List.of(2,3,1);
                List<Integer> l2=List.of(0);
                List<Integer> l3=List.of(0,4);
                List<Integer> l4=List.of(0);
                List<Integer> l5=List.of(2);
                adj.add(l1);adj.add(l2);
                adj.add(l3);adj.add(l4);
                adj.add(l5);
                Solution obj = new Solution();
                ArrayList<Integer> ans = obj.dfsOfGraph(5, adj);
                for (int i = 0; i < ans.size(); i++)
                    System.out.print(ans.get(i) + " ");
                System.out.println();
            }



// } Driver Code Ends


    static class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<List<Integer>> adj) {

            // Code here
            Set<Integer> visited=new LinkedHashSet<>();
            DFSRecursive(0,visited,adj);
            return new ArrayList<>(visited);

        }
        public static void DFSRecursive(int vertex,Set<Integer> visited,ArrayList<List<Integer>> adj)
        {

                if(!visited.contains(vertex))
                {
                    visited.add(vertex);
                    List<Integer> nList=adj.get(vertex);
                    for(int i=0;i<nList.size();i++)
                    {
                        int n=nList.get(i);
                        if(!visited.contains(n))
                        {
                            DFSRecursive(n,visited,adj);
                        }
                    }}

        }
    }
}
