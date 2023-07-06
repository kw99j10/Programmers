class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        //cf)greedy로 푼다면 다음에 올 더 큰 값이 같은 열일 점수에 더할 수 없음 --> 최댓값을 구할 수 없음

      
        int[][] dp = new int[land.length][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4); //첫째 은 land 배열의 값 과 같음

        for (int i = 1; i < land.length; i++) {;
            for (int j = 0; j < 4; j++) {
                for (int t = 0; t < 4; t++) {
                    if (j == t) {
                        continue; //같은 열의 값은 제외
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][t] + land[i][j]);
                }
            }
        }
        
        for (int[] ints : dp) {
            for (int anInt : ints) {
                answer = Math.max(answer, anInt);
            }
        }
        return answer;
    }
}
