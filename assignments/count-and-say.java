class Solution {
    public String countAndSay(int n) {
        String val = "1";
        for(int i=0;i<n-1;i++){
            char c = val.charAt(0);
            StringBuilder s = new StringBuilder();
            int count = 1;
            for(int j=1;j<val.length();j++){
                if(val.charAt(j)!=c){
                    s.append(count);
                    s.append(c);
                    count = 0;
                    c = val.charAt(j);
                }
                count++;
            }
            s.append(count);
            s.append(c);
            val = s.toString();
        }
        return val;
    }
}
//https://leetcode.com/problems/count-and-say/