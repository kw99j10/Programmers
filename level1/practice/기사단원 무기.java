class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int count = 0;
        
        for(int i=1;i<=number;i++){
            
            for(int j=1;j*j<=i;j++){
                if(j*j==i){
                    count+=1; //약수가 자기자신이면 +1
                }
                else if(i%j==0){
                    count+=2; //자기자신이 아닌데 나누어 떨어지면 +2
                }
            }
            if(limit>=count){
                answer+=count; //limit에 따른 덧셈
            }
            else{
                answer+=power;
            }
            count=0;
        }
        return answer;
    }
}
