class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Long> mp = new HashMap<Double,Long>();
        long anss = 0;
         for(int i=0;i<rectangles.length;i++){
          //ratio.push_back(((double)rectangles[i][0]/rectangles[i][1]));
          double ans = (double)rectangles[i][0]/rectangles[i][1];
          mp.put(ans,mp.get(ans)==null?1:mp.get(ans)+1);
        } 
     //   System.out.println(mp);
        for(Map.Entry<Double,Long> mpp:mp.entrySet()){
         // System.out.println(mpp.getValue());
          long temp = (long)(mpp.getValue())-1;
          anss+= (temp*(temp+1))/2;
        }
        return anss;

    }
}
https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/