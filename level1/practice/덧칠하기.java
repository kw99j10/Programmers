class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int paint=0; //덧칠할 범위
        
        for(int i=0;i<section.length;i++){
            
            if(i==0){
                paint+=section[i]; //한 번의 덧칠은 반드시 하므로
                answer+=1;
            }
            
            if(paint+m>section[i]){
                continue; //현재 값이 이전에 덧칠한 부분에 포함되면 이미 덧칠한 부분이므로 넘어감
            }
            paint=section[i]; //덧칠한 부분이 아니면 범위 변수에 추가 후 횟수 증가
            answer+=1;
        }
        return answer;
    }
}
