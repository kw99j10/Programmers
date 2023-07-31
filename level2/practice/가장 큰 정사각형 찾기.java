class Solution
{
    public int solution(int [][]board)
    {
        int answer=0;
        
        int[][] dp = new int[board.length + 1][board[0].length + 1];

        int max = 0;
        for (int i = 1; i <= dp.length - 1; i++) {
            for (int j = 1; j <= dp[i].length - 1; j++) {
                if (board[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1; //3개 중 최솟값을 구하여 1을 더해나감 ==>가장 큰 사각형의 변의 길이(dynamic programming)
                    max = Math.max(max, dp[i][j]);   
                }
            }
        }
        answer = max * max;
        return answer;
    }
}
