class Solution {

    // public String toLowerCase(String s) {
    //     return s.toLowerCase();
    // }

    public String toLowerCase(String s) {
        char ch[] = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(ch[i]>='A' && ch[i]<='Z'){
                int asci_val = ch[i];
                asci_val = asci_val + 32;
                ch[i] = (char)asci_val;
            }
        }
        String str = String.valueOf(ch);
        return str;
    }
}