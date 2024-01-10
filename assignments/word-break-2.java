class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<>();
        return findSentences(s, wordDict, 0, memo);
    }
    private List<String> findSentences(String s, List<String> dict, int pos, Map<Integer, List<String>> memo){
        if(memo.containsKey(pos)){
            return memo.get(pos);
        }
        List<String> subSequence = new ArrayList<>();
        List<String> nextSequence = new ArrayList<>();
        for(int i=pos;i<s.length();i++){
            String currWord = s.substring(pos, i+1);
            if(dict.contains(currWord)){
                if(i + 1 == s.length()) {
					subSequence.add(currWord);
				} else {
                    nextSequence = findSentences(s, dict, i+1, memo);
                    for(int j=0;j<nextSequence.size();j++){
                        subSequence.add(currWord + " " + nextSequence.get(j));
                    }
                }
            }
        }
        memo.put(pos, subSequence);
        return subSequence;
    } 
}
//https://leetcode.com/problems/word-break-ii/