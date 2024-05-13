class Solution {
    public class Pair{
        String first;
        int second;
        Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0;i<len;i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        // N * word.length * 26
        while(!q.isEmpty()){
            Pair top = q.poll();
            String word = top.first;
            int steps = top.second;

            if(word.equals(endWord)) return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArr = word.toCharArray();
                    replacedCharArr[i] = ch;
                    String replacedWord = new String(replacedCharArr);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
//https://leetcode.com/problems/word-ladder/