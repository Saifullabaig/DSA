class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            int temp = i;
            int flag = 1;
            while(temp>0){
                int rem = temp % 10;
                if(rem == 0 || i%rem !=0){
                    flag = 0;
                    break;
                }
                temp = temp/10;
            }
            if(flag == 1){
                result.add(i);
            }             
        }
        return result;
    }
}