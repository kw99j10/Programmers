class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int count=0;
        boolean b=false;
        //cf)범위: 사람 수x말해야 하는 숫자 개수
        for(int i=0;i<=t*m;i++){
            
            if(b){
                break;
            }
            String s=Integer.toString(i,n).toUpperCase(); //진법변환 & 대문자 변환
         
            for(int j=0;j<s.length();j++){
                
                char c=s.charAt(j);
              
                if(answer.length()==t){
                    b=true;
                    break; //말해야 하는 숫자 개수를 채우면 종료
                }
                if(count==m){
                    count=0;  //모든 사람이 말하면 처음부터 다시 시작
                }    
                count+=1;
              
                if(count==p){
                    answer+=c;
                }
            }
        }
        return answer;
    }
}
