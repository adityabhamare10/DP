package DP.zeroOneKnapsack;

public class Solution {

    public static int knapsackTopDown(int wt[], int val[], int w, int n){

        int dp[][] = new int[n+1][w+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][w];

    }

    public static int knapsackMemoization(int wt[], int val[], int w, int n){

        int dp[][] = new int[n+1][w+1];

        // ############ Not Necessary ############## 
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
         // ############3333333333333############## 

        if(n==0 || w==0){
            return 0;
        }

        if(dp[n][w] != 0){
            return dp[n][w];
        }

        if(wt[n-1] <= w){
            dp[n][w] = Math.max(val[n-1] + knapsackMemoization(wt, val, w-wt[n-1], n-1), knapsackMemoization(wt, val, w, n-1));
            return Math.max(val[n-1] + knapsackMemoization(wt, val, w-wt[n-1], n-1), knapsackMemoization(wt, val, w, n-1));

        }else{
            dp[n][w] = knapsackMemoization(wt, val, w, n-1);
            return knapsackMemoization(wt, val, w, n-1);
        }

    }

    public static int knapsackRecursion(int wt[], int val[], int w, int n){


        if(n==0 || w==0){
            return 0;
        }

        if(wt[n-1] <= w){
            return Math.max(val[n-1] + knapsackMemoization(wt, val, w-wt[n-1], n-1), knapsackMemoization(wt, val, w, n-1));

        }else{
            return knapsackMemoization(wt, val, w, n-1);
        }

    }
    
    public static void main(String args[]){
        int wt[] = {1, 3, 4, 5};
        int val[] = {1, 4, 5, 7};
        int w = 7;
        System.out.println("Simple Recursion: "+knapsackRecursion(wt, val, w, wt.length));
        System.out.println("Memoization: "+knapsackMemoization(wt, val, w, wt.length));
        System.out.println("Top-Down (i.e. Tabulation): "+knapsackTopDown(wt, val, w, wt.length));

    }

}
