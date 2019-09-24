/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 *
 * Note:
 *
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 */
 
 
 class Solution {
    //沙漠开车之旅，看油能不能兜一圈回来~不能的话就要被留在沙漠了，所以就暴力开车吧
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int temp_result=runTank(i, gas, cost);
            if(temp_result!=-1)
                return i;
        }
        return -1;
    }
    private int runTank(int start,int[] gas, int[] cost){
        int i=-1;
        int cur_gas=0;
        while(i!=start){
            if(i==-1)
                i=start;
            cur_gas+=gas[i];
            cur_gas-=cost[i];
            if(cur_gas<0)
                return -1;
            i=(i+1)%gas.length;
        }
        return 1;
    }
}
