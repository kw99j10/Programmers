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

//2번 째 풀이 -> 날짜의 합으로 계산
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        String[] current = today.split("\\.");

        int current_year = Integer.parseInt(current[0]); //현재 년도
        int current_month = Integer.parseInt(current[1]); //현재 월
        int current_day = Integer.parseInt(current[2]); //현재 일

        //현재 년도 + 월 + 일을 숫자의 총합으로 표현
        int current_total = current_year * 12 * 28 + current_month * 28 + current_day;
        
        var h = new HashMap<String, Integer>();
        for (String term : terms) {
            String[] t = term.split(" ");
            h.put(t[0], Integer.parseInt(t[1])); //약관 종류, 유효 기간을 저장
        }

        var a = new ArrayList<Integer>(); //만료된 개인정보를 담을 리스트

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");

            String[] year = tmp[0].split("\\."); //날짜
            String category = tmp[1]; //약관 종류

            //개인정보 수집 시작 기간
            int pv_year = Integer.parseInt(year[0]);
            int pv_month = Integer.parseInt(year[1]);
            int pv_day = Integer.parseInt(year[2]);

            int pv_total = pv_year * 12 * 28 + pv_month * 28 + pv_day;
            
            pv_total += h.get(category) * 28;

            //당일 날짜까지라면 만료되었으므로 리스트에 추가
            if (current_total >= pv_total) {
                a.add(i + 1);
            }
        }
        int[] answer = new int[a.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
}
