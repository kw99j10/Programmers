class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
         int []dp=new int[y+1];

        for (int i = x + 1; i <= y; i++) {

            //a,b,c의 초기값은 덤프값으로 지정
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            //dp를 이용하여 배열 값을 채워나간다.(최소 연산 횟소 비교: x2, x3, +n)
            if (i / 2 >= x && i % 2 == 0) {
                a = dp[i / 2];
            }
            if (i / 3 >= x && i % 3 == 0) {
                b = dp[i / 3];
            }
            if (i - n >= x) {
                c = dp[i - n];
            }
            int min = Math.min(a, Math.min(b, c));

            dp[i] = Integer.MAX_VALUE > min ? min + 1 : Integer.MAX_VALUE; //맨 처음 시작하는 지점의 값은 0이기에 최솟값(min)에 1을 더해줌
        }
        answer=Integer.MAX_VALUE>dp[y]?dp[y]:-1; //dp[y]에 해당하는 값은 덤프값이면 만들 수 없다는 뜻이므로 -1을 반환
        return answer;
    }
}
