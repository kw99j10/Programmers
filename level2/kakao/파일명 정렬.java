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
                    break;
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
