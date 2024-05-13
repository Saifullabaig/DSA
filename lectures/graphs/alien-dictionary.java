import java.util.*;

public class Solution {
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        int n = dictionary.length;
        for(int i=0;i<n-1;i++){
            String s1 = dictionary[i];
            String s2 = dictionary[i+1];
            int min = Math.min(s1.length(), s2.length());
            for(int p=0;p<min;p++){
                if(s1.charAt(p) != s2.charAt(p)){
                    adj.get(s1.charAt(p) - 'a').add(s2.charAt(p) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(k, adj);
        String ans = "";
        for (int it : topo) {
            ans = ans + (char)(it + (int)('a'));
        }

        return ans;

    }

    static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }
}
//https://www.codingninjas.com/studio/problems/alien-dictionary_630423?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf