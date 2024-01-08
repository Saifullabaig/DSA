class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        dfs(0, s, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, String s, ArrayList<String> currentList, List<List<String>> res){
        if(start>=s.length()){
            res.add(new ArrayList<>(currentList));
        }

        for(int end = start;end<s.length();end++){
            if(isPalindrome(start, end, s)){
                currentList.add(s.substring(start, end+1));
                dfs(end+1, s, currentList, res);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}
//https://leetcode.com/problems/palindrome-partitioning/