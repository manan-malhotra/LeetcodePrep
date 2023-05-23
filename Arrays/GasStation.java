// https://leetcode.com/problems/gas-station/

// There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station 
// to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

// Given two integer arrays gas and cost, return the starting gas station's 
// index if you can travel around the circuit once in the clockwise direction,
//  otherwise return -1. If there exists a solution, it is guaranteed to be unique

// Tags: Arrays, Greedy

package Arrays;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int totalCost = 0;
        int amount = 0;
        for(int i=0;i<gas.length;i++){
            totalCost += gas[i]-cost[i];
            amount += gas[i]-cost[i]; 
            if(amount<0){
                start = i+1;
                amount = 0;
            }
        }
        if(totalCost>=0) return start;
        return -1;
    }
}
