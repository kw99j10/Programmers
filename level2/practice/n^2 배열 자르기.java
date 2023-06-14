class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        for(int i=0;i<answer.length;i++){
            
            //형변환 필요(long->int)
            int a=(int)(left%n)+1; //조건에 따라 i행 i열에 i를 채우므로.. i는 행과 열의 최댓값임 ex)2행 1열=1행 2열 -> i=2
            int b=(int)(left/n)+1;
            
            answer[i]=Math.max(a,b);
            left+=1; //left~right까지 1씩 증가)
        }
        return answer;
    }
}
