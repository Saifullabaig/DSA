import java.util.*;
class Solution {
  class Item{
    int value;
    int weight;
    Item(int x, int y){
      this.value  = x;
      this.weight = y;
    }
  }
  class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b){
      double r1 = (double)(a.value) / (double) (a.weight);
      double r2 = (double)(b.value) / (double) (b.weight);
      if(r1<r2) return 1;
      else if(r1>r2) return -1;
      else return 0;
    }
  }
    public double fractionalKnapsack(int N, int W, List<Integer> values, List<Integer> weight) {
      //Write your code here 
      Item arr[] = new Item[values.size()];
      for(int i=0;i<values.size();i++){
        arr[i] = new Item(values.get(i), weight.get(i));
      }
      Arrays.sort(arr, new ItemComparator());
      int currWeight = 0;
      double finalValue  = 0.0;
      for(int i=0;i<N;i++){
        if(currWeight + arr[i].weight <= W){
          currWeight = currWeight + arr[i].weight;
          finalValue = finalValue  + arr[i].value;
        }else{
          int remain = W - currWeight;
          finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
          break;
        }
      }
      return finalValue;

 }
}