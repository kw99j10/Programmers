class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

      
        //n*n 배열로 크기를 맞추기 위함
        int [][]k=new int[triangle.length+1][triangle.length+1];
        for(int i=0;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                k[i][j]=triangle[i][j];
            }
        }
        int [][]dp=new int[k.length+1][k.length+1];
      
        //dp 방식으로 max(answer)값 탐색
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){

                if (i==1){
                    if (j==1){
                        dp[i][j]=k[i-1][j-1];
                    }
                }
                if(i==2){
                    dp[i][j]=dp[1][1]+k[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+k[i-1][j-1];
                    answer=Math.max(answer,dp[i][j]);
                }
            }
        }
        
        return answer;
    }
}
