class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer[], Integer> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
            int p1 = points[i][0];
            int p2 = points[i][1];
            int dis = Math.abs((p2*p2) + (p1*p1));
            Integer[] arr = new Integer[]{p1,p2};
            map.put(arr, dis);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> (map.get(a) == map.get(b))
                                                                    ? Integer.compare(a[0], b[0]) 
                                                                    : map.get(a) - map.get(b));
        pq.addAll(map.keySet());
        int[][] ans = new int[k][2];
        for(int i=0;i<k && !pq.isEmpty(); i++){
            Integer[] temp = pq.poll();
            ans[i][0] = temp[0];
            ans[i][1] = temp[1];
        }
        return ans;
    }
}
//https://leetcode.com/problems/k-closest-points-to-origin/