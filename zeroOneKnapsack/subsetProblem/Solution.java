package DP.zeroOneKnapsack.subsetProblem;

public class Solution {


    // bottom up Approach i.e. tabulation
    public static boolean subsetProblemTabulation(int arr[], int sum){
        
        boolean dp[][]= new boolean [arr.length+1][sum+1];

        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }
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








    // memization 

    private static boolean isSubsetSum(int arr[], int n, int sum, Boolean dp[][]) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        if (arr[n-1] > sum) {
            dp[n][sum] = isSubsetSum(arr, n-1, sum, dp);
        } else {
            dp[n][sum] = isSubsetSum(arr, n-1, sum, dp) || isSubsetSum(arr, n-1, sum - arr[n-1], dp);
        }

        return dp[n][sum];
    }

    public static boolean subsetProblemMemoization(int arr[], int sum) {
        Boolean dp[][] = new Boolean[arr.length + 1][sum + 1];
        return isSubsetSum(arr, arr.length, sum, dp);
    }
    
    public static void main(String args[]){
        int arr[] = {2,10,7,8,10,10};
        System.out.println(subsetProblemTabulation(arr, 11));
        System.out.println(subsetProblemMemoization(arr, 11));

    }

}
