class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0, totalCost = 0;
        int start = 0, current = 0;
        for(int i=0;i<gas.length;i++){
            totalFuel += gas[i];
            totalCost += cost[i];
        }
        if(totalFuel < totalCost) return -1;
        for(int i=0;i<gas.length;i++){
            current += (gas[i] - cost[i]);
            if(current < 0){
                start = i+1;
                current = 0;
            }
        }
        return start;
    }
}
//https://leetcode.com/problems/gas-station/