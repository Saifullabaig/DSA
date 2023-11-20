class Solution {
    public boolean judgeCircle(String moves) {
        char[] positions = moves.toCharArray();
        int uCount = 0;
        int rCount = 0;
        for(char pos : positions){
            if(pos == 'R'){
                rCount++;
            }
            else if(pos == 'L'){
                rCount--;
            }
            else if(pos == 'U'){
                uCount++;
            }else{
                uCount--;
            }
        }
        if(rCount == 0 && uCount == 0){
            return true;
        }
        return false;
    }
}