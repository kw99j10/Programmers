class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        double result1=Math.pow(r1,2); //반지름이 r1인 원의 원점과의 거리
        double result2=Math.pow(r2,2); //반지름이 r2인 원의 원점과의 거리

        for (int i = 1; i <= r2; i++) {

            int distance1=(int)Math.floor(Math.sqrt((result2-Math.pow(i,2)))); //두 점 사이의 거리가 result2보다 작거나 같은 정수여야 함
            int distance2=(int)Math.ceil(Math.sqrt((result1-Math.pow(i,2))));  //두 점 사이의 거리가 result1보다 크거나 같은 정수여야 함
            answer += distance1 - distance2 + 1;
        }
        answer*=4; //4사분면이므로 구한 answer에 x 4
      
        return answer;
    }
}
