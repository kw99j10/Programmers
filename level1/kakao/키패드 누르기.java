class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left=10; //키패드 *의 위치
        int right=12; //키패드 #의 위치
        for(int i=0;i<numbers.length;i++){
            int n=numbers[i];
            if(n==0){
                n=11; //키패드 0의 위치
            }
            
            //1,4,7 키패드
            if(n%3==1){
                answer+="L";
                left=n;
            }
            
            //3,6,9 키패드
            else if(n%3==0){
                answer+="R";
                right=n;
            }
            
            //2,5,8,0 키패드
            else{
                int left_distance=Math.abs(left-n)/3+Math.abs(left-n)%3;
                int right_distance=Math.abs(right-n)/3+Math.abs(right-n)%3;
                
                if(left_distance>right_distance){
                    answer+="R";
                    right=n;
                }
                else if(right_distance>left_distance){
                    answer+="L";
                    left=n;
                }
                else{
                    if(hand.equals("right")){
                        answer+="R";
                        right=n;
                    }
                    else{
                        answer+="L";
                        left=n;
                    }
                }
            }
        }
        return answer;
    }
}
