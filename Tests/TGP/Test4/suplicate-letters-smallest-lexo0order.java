import java.util.Stack;
class Solution {
    public String removeDuplicateLetters(String s) {
      int[] lastOccurence = new int[26];
      boolean[] seen = new boolean[26];
      Stack<Character> st = new Stack<>();
      for(int i=0;i<s.length();i++){
        lastOccurence[s.charAt(i)-'a']=i;
      }
      for(int i=0;i<s.length();i++){
        char curr = s.charAt(i);
        if(seen[curr - 'a']){
          continue;
        }

        while(!st.isEmpty() && curr < st.peek() && i < lastOccurence[st.peek()- 'a']){
          seen[st.peek() - 'a'] = false;
          st.pop();
        }
        st.push(curr);
        seen[curr-'a'] = true;
      }

      StringBuilder result = new StringBuilder();
      while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }

      return result.toString();
    }
}
