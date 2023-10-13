class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        double result1=Math.pow(r1,2); //반지름이 r1인 원의 원점과의 거리
        double result2=Math.pow(r2,2); //반지름이 r2인 원의 원점과의 거리

        //반복문이 1부터 시작하는 이유: 0부터 시작하면 x축, y축 2번씩 포함되어 중복 계산이 발생함
        for (int i = 1; i <= r2; i++) {
            double y1=(long)Math.floor(Math.sqrt((result2-Math.pow(i,2)))); //큰 원의 y값이 (r*2-i*2)보다 작거나 같은 정수여야 함
            double y2=(long)Math.ceil(Math.sqrt((result1-Math.pow(i,2))));  //작은 원의 y값이 (r*2-i*2)보다 크거나 같은 정수여야 함
            answer += y1 - y2 + 1; //큰 원에서 작은 원을 빼야 두 원 사이의 정수 쌍이 나온다. 이 후 작은 원과 큰 원이 겹치는 부분을 +1 해줘야 함
        }
        answer*=4; //4사분면이므로 구한 answer에 x 4
      
        return answer;
    }
}
