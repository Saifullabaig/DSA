class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> hp = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        hp.add(s);

        boolean flag = false;
        while(!q.isEmpty()){
            String x = q.remove();
            if(check(x)){
                res.add(x);
                flag = true;
            }
            if(flag) continue;
            for(int i=0;i<x.length();i++){
                char ch = x.charAt(i);
                if(ch!='(' && ch!=(')')) continue;
                String t = x.substring(0,i) + x.substring(i+1);
                if(!hp.contains(t)){
                    q.add(t);
                    hp.add(t);
                }
            }
        }
        return res;
    }
    boolean check(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') count++;
            if(c == ')') count--;
            if(count<0) return false;
        }
        return count == 0;
    }
}

//https://leetcode.com/problems/remove-invalid-parentheses/