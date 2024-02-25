// There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

// A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

// Return all critical connections in the network in any order.

// Example 1
// Input
// n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// Output
// [[1,3]]
// Explanation:
// [[3,1]] is also accepted.

// Example 2
// Input
//  n = 2, connections = [[0,1]]
// Output
// [[0,1]]
// Constraints:
// 2 <= n <= 105
// n - 1 <= connections.length <= 10^5
// 0 <= ai, bi <= n - 1
// ai != bi
// There are no repeated connections.

class Solution {
    
    private int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, int[][] g) {
        List<List<Integer>> result = new ArrayList<>();
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : g) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }

        dfs(0, -1, disc, low, visited, graph, result);

        return result;
    }

    private void dfs(int u, int parent, int[] disc, int[] low, boolean[] visited, List<Integer>[] graph, List<List<Integer>> result) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v, u, disc, low, visited, graph, result);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
        
}
