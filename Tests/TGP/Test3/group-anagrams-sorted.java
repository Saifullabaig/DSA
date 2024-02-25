class Solution {
    public void groupAnagrams(String[] strs) {
        // Your logic for grouping anagrams goes here
      Map<String, List<String>> map = new HashMap<>();
      for(String str: strs){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        String newStr = new String(c);
        if(map.containsKey(newStr)){
          map.get(newStr).add(str);
        }else{
          List<String> li = new ArrayList<>();
          li.add(str);
          map.put(newStr, li);
        }
      }
      List<List<String>> result = new ArrayList<>(map.values());
      for(List<String> group: result){
        Collections.sort(group);
      }
      result.sort(Comparator.comparing(group -> group.get(0)));
      
      for(List<String> group: result){
        for(String anagram: group){
          System.out.print(anagram);
          System.out.print(" ");
        }
        System.out.println("");
      }
    }
}
