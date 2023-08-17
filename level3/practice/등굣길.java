class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int [][]dp=new int[n+1][m+1];
        
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1; //물에 잠긴 지역 표시
        }
        dp[1][1]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
              
                if(i==1 && j==1){
                    continue;
                }
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=dp[i-1][j]%1000000007+dp[i][j-1]%1000000007;
                }
            }
        }
        
        answer=(dp[n][m])%1000000007;
        return answer;
    }
}
