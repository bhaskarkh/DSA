package org.bhaskar.graph;

import java.util.*;

public class GraphJudgeProblem {
    public static void main(String[] args) {
        int[][] multi = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(3,multi));
    }
    public static int findJudge(int n, int[][] trust){
        int[] count=new int[n+1];
        for(int[] t:trust)
        {
            count[t[0]-1]--;
            count[t[1]-1]++;
        }
        for(int i=1;i<=n;i++)
        {
            if(count[i-1]==n-1) return i;
        }
        return -1;

    }
    public static int findJudge1(int n, int[][] trust) {
        Set<Integer> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        map.put(trust[0][0],1);
        set.add(trust[0][1]);
        int i=0;
        for(int[] intArr:trust) {
            if (i == 0) {
                i++;
                continue;
            }
            int val = intArr[1];
            int key= intArr[0];
            set.add(val);
            if(map.containsKey(key))
              map.put(key,map.get(key)+1);
            else
                map.put(key,1);
        }
        for(Integer d:set)
        {
            if(!map.containsKey(d)) return d;
        }

        return -1;
    }
}
