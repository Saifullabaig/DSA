class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> oddPq = new PriorityQueue<>();
        PriorityQueue<Integer> evenPq = new PriorityQueue<>();
        int temp = num;
        while(num>0){
            int curr = num%10;
            if(curr%2 == 0){
                evenPq.add(curr); //1,3
            }else{
                oddPq.add(curr); //2,4
            }
            num = num/10;
        }
        StringBuilder sb = new StringBuilder();
        num = temp;
        while(num>0){
            int curr = num%10;
            if(curr%2 == 0){
                sb.insert(0, evenPq.poll());
            }else{
                sb.insert(0, oddPq.poll()); // 3,4,1,2
            }
            num = num/10;
        }
        return Integer.parseInt(sb.toString());
    }
}
//https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/