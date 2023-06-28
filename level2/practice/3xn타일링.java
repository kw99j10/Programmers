class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n%2==1){
            return 0; //홀수는 타일을 이용하여 바닥을 가득 채울 수 없음
        }
        long []a=new long[n+1];

        //dp 알고리즘: dp[n]=dp[n-1]*4-dp[n-2]
        a[0]=1;
        a[1]=3;
              
        for(int i=2;i<=n/2;i++){
            a[i]=((a[i-1]%1000000007)*4-(a[i-2]%1000000007)+1000000007)%1000000007; //1000000007을 더해주는 이유: 중간에 음수가 나오는 경우를 방지
        }
        answer=(int)(a[n/2]%1000000007);
        return answer;
    }
}
