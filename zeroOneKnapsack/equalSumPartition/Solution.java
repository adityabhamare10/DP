package DP.zeroOneKnapsack.equalSumPartition;

public class Solution {

    public static boolean subset(int arr[], int sum){
        
        boolean dp[][]= new boolean [arr.length+1][sum+1];

        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1; i<arr.length+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[arr.length][sum];
    }

    public boolean canPartition(int[] nums) {
        
        int totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum+=nums[i];
        }
        
        if(totalSum % 2 != 0) return false;
        
        return subset(nums, totalSum/2);
    }

    public static void main(String args[]){

        int nums[] = {1, 5, 11, 5};
        Solution obj = new Solution();
        System.out.println(obj.canPartition(nums));

    }
}
