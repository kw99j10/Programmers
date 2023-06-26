import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
       
        var a=new ArrayList<Integer>();
        
        var h=new HashMap<String,Integer>();
        for(int i=0;i<terms.length;i++){
            String []t=terms[i].split(" ");
            h.put(t[0],Integer.parseInt(t[1])); //약관 종류에 따른 유효 기간을 map에 담음
        }
        
        String []t=today.split("\\."); //오늘날(현재) 연도(연, 월, 일)을 분리(연, 월, 일)비교 위함
        int y=Integer.parseInt(t[0]);
        int m=Integer.parseInt(t[1]);
        int d=Integer.parseInt(t[2]);
        
        for(int i=0;i<privacies.length;i++){
            String []p=privacies[i].split(" ");
            String tmp=p[1]; //약관 종류
            String[] k = p[0].split("\\."); //연도
            
            int year=Integer.parseInt(k[0]); //연
            int month=Integer.parseInt(k[1]); //월
            int days=Integer.parseInt(k[2]); //일
 
            int tmp_months=month+h.get(tmp);  //주어진 달+약관 종류의 유효 기간(달)
            int tmp_years=year+tmp_months/12; //month가 12를 넘어가면 year에 더함
            int tmp_days=days;
            
            tmp_months%=12;
            
            if(tmp_months==0){ //month는 0일 수 없으므로 1년을 감소한 후 12월로 치환
                tmp_years-=1;
                tmp_months=12;
            }

            //cf)유효기간은 그 전날 까지 이므로 days-1
            if(tmp_days==1){
                if(tmp_months==1){
                    tmp_years-=1;  //1월 1일의 경우 1년 감소, 12월로 치환
                    tmp_months=12;
                }
                else{
                    tmp_months-=1; //days만 1일 경우, month-1
                }
                tmp_days=28;
            }
            else{
                tmp_days-=1; //그 외
            }

            //유효 기간이 만료 되었는지 검사하여 리스트에 담음
            if(y>tmp_years){
                a.add(i+1);
            }
            else if(y==tmp_years){
                if(m>tmp_months){
                    a.add(i+1);
                }
                else if(m==tmp_months){
                    if(d>tmp_days){
                        a.add(i+1);
                    }
                }
            }
            //System.out.println(tmp_years+" "+tmp_months+" "+tmp_days);
        }
            
        int[] answer = new int[a.size()];
        for (int i=0;i<answer.length;i++){
            answer[i]=a.get(i);
        }
        return answer;
    }
}
