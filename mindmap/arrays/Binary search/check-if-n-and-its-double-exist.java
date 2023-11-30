class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            if(map.containsKey(2*num) || num%2 == 0 && map.containsKey(num/2)) return true;
            map.put(num, 0);
        }
        return false;
    }
}
//https://leetcode.com/problems/check-if-n-and-its-double-exist/