import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        var a=new ArrayList<String>(); //메시지를 담을 list
        var h=new HashMap<String,String>(); //id에 따른 name 을 담을 map

        //닉네임을 변경한 기록을 담는 과정
        for(int i=0;i<record.length;i++){
            String []st=record[i].split(" ");
            if(st.length>2){
                h.put(st[1],st[2]); //id와 name  key-value 대입
            }
        }
        for(int i=0;i<record.length;i++){
            String []st=record[i].split(" ");      
            String first=st[0];
            if(first.equals("Change")){
                continue; //"Change"는 영향을 주지 않음 --> map에 마지막으로 저장된 id에 따른 name값만 신경 쓰면 되므로
            }
            else if(first.equals("Enter")){
                a.add(h.get(st[1])+"님이 들어왔습니다.");
            }
            else if(first.equals("Leave")){
                a.add(h.get(st[1])+"님이 나갔습니다.");
            }
        }
        String[] answer=new String[a.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=a.get(i);
        }
        return answer;
    }
}
