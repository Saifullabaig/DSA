class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '-' || ch == '*' || ch == '+'){
                List<Integer> a1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> b1 = diffWaysToCompute(input.substring(i+1));
                for(int x : a1){
                    for(int y : b1){
                        if(ch == '+'){
                            res.add(x+y);
                        }else if(ch == '-'){
                            res.add(x-y);
                        }else if(ch == '*'){
                            res.add(x*y);
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
//https://leetcode.com/problems/different-ways-to-add-parentheses/