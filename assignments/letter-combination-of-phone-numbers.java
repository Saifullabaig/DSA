class Solution {
    String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }
    private void dfs(String digits, int index, StringBuilder temp, List<String> res){
        if(index == digits.length()){
            res.add(temp.toString());
            return;
        }
        char digit = digits.charAt(index);
        String str = mapping[digit - '0'];
        for(char c: str.toCharArray()){
            temp.append(c);
            dfs(digits, index+1, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/