class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int []dp=new int[15]; //주어진 괄호 쌍의 개수 범위

        //카탈란 수: 1,1,2,5,14, ....
        dp[0]=1;
        dp[1]=1;

        //ex) 만약 n이 3이라면 dp[3]=dp[2]*dp[0]+dp[1]*dp[1]+dp[0]*dp[2] 형태로써 이전 항들을 이용하여 2중 for 문으로 dp를 수행할 수 있음
        for (int i = 2; i < 15; i++) {
           for(int j = 0; j < i; j++) {
                dp[i] += dp[i - j - 1] * dp[j]; 
            }
        }
        
        /*for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }*/
        answer = dp[n];
        //System.out.println(answer);
        return answer;
    }
}
