class Solution {
    public String largestNumber(int[] nums) {
        List<String> li = new ArrayList<>();
        for(int num: nums){
            li.add(String.valueOf(num));
        }
        Collections.sort(li, new Comparator<>(){
            public int compare(String A, String B){
                String AB = A+B;
                String BA = B+A;
                return AB.compareTo(BA) > 0 ? -1 : 1; 
            }
        });

        String res = "";
        for(int i=0;i<li.size();i++){
            res += li.get(i);
        }
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}
//https://leetcode.com/problems/largest-number/