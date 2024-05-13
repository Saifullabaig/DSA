/*
Encoder
Given an array of words, devise a method to encode these words into a single reference string and an array of indices in such a way that:

The length of the array of words equals the length of the array of indices.
The reference string ends with the '#' character.
For each index indices[i], the substring of the reference string starting at indices[i] and ending before the next '#' character equals words[i].
Your task is to return the length of the shortest possible reference string that can be generated to validly encode the given array of words.

Input Format:

The input consists of an array of words words, where each word consists only of lowercase letters.
Output Format:

Return the length of the shortest reference string s possible of any valid encoding of words.
Example 1
Input
words = ["time", "me", "bell"]
Output
`10`
Explanation:
A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
*/
class Solution {
  class TrieNode{
    TrieNode[]  children;
    boolean isEndOfWord;

    TrieNode(){
      children = new TrieNode[26];
    }
  }
  class Trie{
    TrieNode root;
    public Trie(){
      root = new TrieNode();
    }
    public void insert(String word){
      TrieNode node = root;
      for(char c: word.toCharArray()){
        if(node.children[c - 'a'] == null){
          node.children[c-'a'] = new TrieNode();
        }
        node = node.children[c-'a'];
      }
      node.isEndOfWord = true;
    }
    public boolean startsWith(String prefix){
      TrieNode node = root;
      for(char c: prefix.toCharArray()){
        if(node.children[c - 'a'] == null){
          return false;
        }
        node= node.children[c - 'a'];
      }
      return true;
    }
  }
    public int minimumLengthEncoding(String[] W) {
      //Write your code here 
      Trie trie = new Trie();
      for(String word: W){
        trie.insert(new StringBuilder(word).reverse().toString());
      }
      int result = 0;
      for(String word: W){
        if(trie.startsWith(new StringBuilder(word).reverse().toString())){
          result += word.length() + 1;
        }
      }
      return result;
   }
}