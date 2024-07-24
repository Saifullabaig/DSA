class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<s.length()-9;i++){
            String subString = s.substring(i,i+10);
            map.put(subString, map.getOrDefault(subString, 0)+1);
            if(map.get(subString) == 2){
                res.add(subString);
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/repeated-dna-sequences/