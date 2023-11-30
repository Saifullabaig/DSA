class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = -1;
        for(int candy: candies){
            if(candy > largest){
                largest = candy;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int candy: candies){
            if(candy + extraCandies >= largest){
                res.add(true);
            }        
            else{
                res.add(false);
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/