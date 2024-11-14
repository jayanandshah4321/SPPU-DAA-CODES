public class knapSackTABU {
    public static void printarr(int dp[][]){
        int m=dp.length;
        int n=dp[0].length;

        //i-> item  and j->W  so index of item=i=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static int tabu(int dp[][],int val[],int wt[]){
        int m=dp.length;
        int n=dp[0].length;
        for(int i=0;i<m;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=0;
        }
        //i-> item  and j->W  so index of item=i=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++) {
                int value = val[i - 1];
                int w = wt[i - 1];
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //include
                    int includeThisItem = value + dp[i - 1][j - w];
                    //exclude
                    int excludeThisItem = dp[i - 1][j];
                    dp[i][j] = Math.max(includeThisItem, excludeThisItem);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int val[] = {2,3,1,4};
        int wt[] = {3,4,6,5};
        int W = 8;
        int dp[][]=new int[val.length+1][W+1];

        System.out.println(tabu(dp,val,wt));
        printarr(dp);
    }
}
