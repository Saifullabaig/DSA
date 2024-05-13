class Solution {
    public boolean isPowerOfTwo(int n) {
        // int count = 0;
        // for(int i=0;i<32;i++){
        //     if((n & 1) == 1){
        //         count++;
        //     }
        //     n=n>>1;
        // }
        // if(count == 1) return true;
        // return false;
        if(n > 0) {
            if((n&(n-1)) == 0){
                return true;
            }
        }
        return false;
    }
}