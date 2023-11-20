class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int index = -1;
        for(int i=arr.length;i>0;i--){
            index = find(arr, i);
        

            if(index == i-1){
                continue;
            }
            if(index != 0){
                res.add(index+1);
                flip(arr, index+1);
            }
            res.add(i);
            flip(arr, i);
        }
        return res;
    }

    private void flip(int[] arr, int k){
        int i =0;
        while(i<k/2){
            int temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
            i++;
        }
    }
    private int find(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/pancake-sorting/