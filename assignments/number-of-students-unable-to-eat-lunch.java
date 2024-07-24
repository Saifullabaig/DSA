class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleCount = 0, squareCount = 0;
        for(int student: students){
            if(student == 1){
                squareCount++;
            }else{
                circleCount++;
            }
        }
        for(int sandwich: sandwiches){
            if(sandwich ==1){
                if(squareCount > 0){
                    squareCount--;
                }else{
                    break;
                }
            }
            if(sandwich == 0){
                if(circleCount > 0){
                    circleCount--;
                }else{
                    break;
                }
            }
        }
        return squareCount + circleCount;
    }
}
//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/