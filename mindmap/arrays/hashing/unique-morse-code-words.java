class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> transformations = new HashSet<>();
        for(String word: words){
            StringBuilder temp = new StringBuilder();
            for(char c: word.toCharArray()){
                temp = temp.append(morse[c - 'a']);
            }
            transformations.add(temp.toString());
        }
        return transformations.size();
    }
}
//https://leetcode.com/problems/unique-morse-code-words/