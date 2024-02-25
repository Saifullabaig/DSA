// Given that n integers are read from a data stream. Your task is to find the median of the elements read so far. Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the floor of the average of the two middle values.

// Example 1
// Input
// arr = [5,3,8]
// Output
// [5,4,5]
// Explanation
// After reading first element of stream, Median of [5] is 5 After reading second element of stream, Median of [5, 3] = floor((5+3)/2)=4 After reading third element of stream, Median of [5,3,8] = 5 ,it is the middle value of the sorted array So the output will be 5 4 5.

// Example 2:

// Input:

// arr = [1,2,3] 
// Output:

// [1,1,2]
// Constraints:
// 1 <= n <= 10000
// 0 <= arr[i] <= 100000

class Solution {
    public List<Integer> findMedian(List<Integer> arr, int n) {
   // write your code here
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      List<Integer> res = new ArrayList<>();
      for(int i=0;i<arr.size();i++){
        maxHeap.offer(arr.get(i));
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
          maxHeap.offer(minHeap.poll());
        }

        if(maxHeap.size() == minHeap.size()){
          res.add((maxHeap.peek() + minHeap.peek())/2);
        }else{
          res.add(maxHeap.peek());
        }
      }
      return res;

  }
}