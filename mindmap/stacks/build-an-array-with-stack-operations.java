class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ls = new ArrayList<>();
        int count = 1;
        for(int i=0;i<target.length; i++){
            while(count<target[i]){
                ls.add("Push");
                ls.add("Pop");
                count++;
            }
            ls.add("Push");
            count++;
        }
        return ls;
    }
}
//https://leetcode.com/problems/build-an-array-with-stack-operations/