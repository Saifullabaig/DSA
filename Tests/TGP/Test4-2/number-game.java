
class Solution {
    public int numgame(long a, long b, long n) {
        int turn=0;
      while(n>0){
        long stonesTaken = (turn == 0) ? gcd(a, n) : gcd(b, n);
        // System.out.println(stonesTaken);
        if(stonesTaken > n){
          break;
        }
        n = n- stonesTaken;
        turn =  1 - turn;
      }
      return 1-turn;
    }
    private long gcd(long a, long b){
      while(b!=0){
        long temp = b;
        b = a%b;
        a = temp;
      }
      return a;
    }
}


