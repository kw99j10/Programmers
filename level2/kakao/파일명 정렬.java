import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String [][]tmp=new String[files.length][3]; //각각 head, number, tail 값을 저장

        int i=0;
        for (String s : files) {
            String head="";
            String number="";
            String tail=""; //나누어 비교하기 위해 head, number, tail로 나눠서 정렬함

            boolean b=true;
            int temp=0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                //number 조건
                if (c>='0' && c<='9' && number.length()<5){
                    number+=c;
                    b=false;
                }
                else if(!b){
                    break; //number는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으므로 숫자가 나오지 않을 시 break(추후 숫자가 나와도 포함하지 않기 위함)
                }
                else{
                    head+=c;
                }
                temp=j;
            }

            tail=s.substring(temp+1); //number의 계산이 끝난 다음 index부터 tail
            tmp[i][0]=head;
            tmp[i][1]=number;
            tmp[i][2]=tail;
            i+=1;
        }
        Arrays.sort(tmp, (o1, o2) -> {
            if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase())>0){
                return 1; //head 비교
            }
            else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase())<0){
                return -1; //head 비교
            }
            else{
                return Integer.compare(Integer.parseInt(o1[1]),Integer.parseInt(o2[1])); //문자열이 같을 시 number 값 비교
            }
        });
        String []answer=new String[files.length];
        for (int j=0;j<tmp.length;j++){
            answer[j]=tmp[j][0]+tmp[j][1]+tmp[j][2];
        }
        return answer;
    }
}
