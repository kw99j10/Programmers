import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        //다트게임은 총 3번 진행
        int []k=new int[3];
        int count=0;
      
        //문자 단위로 끊어서 계산하기 위한 변수 ex)1S # 2D * 3T
        String number="";

        for (int i=0;i<dartResult.length();i++){
            char c=dartResult.charAt(i);

            if (c>='0' && c<='9') {
                number+=String.valueOf(c);
            }
            else if(c=='S' || c== 'D' || c=='T'){

                if (c=='S'){
                    k[count]=Integer.parseInt(number);
                }
                else if(c=='D'){
                    k[count]=(int)Math.pow(Integer.parseInt(number),2);
                }
                else{
                    k[count]=(int)Math.pow(Integer.parseInt(number),3);
                }
                number="";
                count+=1;
            }
            else{
                if (c=='#'){
                    k[count-1]*=-1;
                }
                else{
                    if (count-2>=0){
                        k[count-2]*=2;
                    }
                    k[count-1]*=2;
                }
            }
        }
        answer=k[0]+k[1]+k[2];
        
        return answer;
    }
}
