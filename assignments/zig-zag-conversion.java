class Solution {
    public String convert(String s, int numRows) {
        
        //define string builder
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sbs[i] = new StringBuilder();
        }
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;
        
        while(index < n){
            //go down
            for(int j = 0; j < numRows && index < n; j++){
                sbs[j].append(arr[index++]);
            }
            
            //go up
            for(int j = numRows - 2; j > 0 && index < n ; j--){
                sbs[j].append(arr[index++]);
            }
        }
        
        //combine
        StringBuilder res = sbs[0];
        for(int i = 1; i< numRows;i++){
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
//https://leetcode.com/problems/zigzag-conversion/