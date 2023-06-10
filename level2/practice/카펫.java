class Solution {
    public int[] solution(int brown, int yellow) {
      
        //가로와 세로를 리턴하는 배열 (가로>=세로)
        int[] answer = new int[2];
        
        //brown과 yellow의 최소로 하는 약수 쌍을 구함
        int k=brown+yellow;
        
      
        //세로의 최소길이는 3이므로 3부터 시작
        for(int i=3;i<k;i++){
            int j=k/i;
            
            //가로의 길이 역시 3보다 크거나 같으므로
            if(k%i==0 && j>=3){
                
                //구한 가로와 세로는 전체 타일의 가로와 세로이고 이는 yellow 타일보다 +2이므로, 
                //(구한 가로-2)x(구한 세로-2)의 크기가 yellow의 가로,세로 길이여야함
                if((i-2)*(j-2)==yellow){
                    answer[0]=Math.max(i,j);
                    answer[1]=Math.min(i,j);
                }
            }
        }
        return answer;
    }
}
