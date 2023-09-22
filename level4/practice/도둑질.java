class Solution {
    public int solution(int[] money) {
        int answer = 0;

        int []dp1=new int[money.length];
        int []dp2=new int[money.length];
        
        dp1[0]=money[0];
        dp1[1]=Math.max(dp1[0],money[1]);
        for(int i=2;i<money.length-1;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+money[i]);
        }
        dp1[dp1.length-1]=dp1[dp1.length-2];
        
        dp2[0]=money[1];
        dp2[1]=Math.max(dp2[0],money[2]);
        for(int i=2;i<money.length-1;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+money[i+1]);
        }
        dp2[dp2.length-1]=dp2[dp2.length-2];
        
        answer=Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
        return answer;
    }
}
