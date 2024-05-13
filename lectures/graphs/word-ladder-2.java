class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ArrayList<String> vec = q.poll();
            if(vec.size()>level){
                level++;
                for(String it: usedOnLevel){
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size()-1);
            if(word.equals(endWord)){
                if(ans.size() == 0) ans.add(vec);
                else if(ans.get(0).size() == vec.size()) ans.add(vec);
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArr = word.toCharArray();
                    replacedCharArr[i] = ch;
                    String replacedWord = new String(replacedCharArr);
                    if(st.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    } 
                }
            }
        }
        return ans;
    }
}
//https://leetcode.com/problems/word-ladder-ii/