public class Solution {
	public int pow(int x, int n, int d) {
    if (x == 0) return 0;
    long res = 1;
    boolean flag = false;
    if(x < 0){
        if(n%2==1){
            flag = true;
        }
        x = -x;
    }
    
    while(n > 0){
        if(n%2==1){
            res = (res * (long)x)%d;
        }
        n = n/2;
        long sq = (long)x * (long)x;
        x = (int)(sq%d);
    }

    if(flag){
        return (int) d - (int)res;
    }else{
        return (int) res;
    }
	}
}
//https://www.interviewbit.com/problems/implement-power-function/