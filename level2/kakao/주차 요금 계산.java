import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
      
        var money=new HashMap<String,Integer>(); //차량번호, 주차요금
        var time=new HashMap<String,String>(); //차량번호, 주차시간

        for (String record : records) {
            String[] tmp = record.split(" ");
            money.put(tmp[1], 0); //차량 번호에 대한 시간을 0으로 초기화
        }
        
        for (String record : records) {
            String[] tmp = record.split(" ");
          
            if (time.containsKey(tmp[1])) { //tmp[2].equals("OUT")
                String[] in = time.remove(tmp[1]).split(":"); //기존 key(차량번호)에 저장된 value(출입시간) 을 h:m 꼴로 쪼개어 계산
                String[] out = tmp[0].split(":"); //out에 대한 h:m value쌍

                int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int min = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                money.put(tmp[1], money.get(tmp[1]) + (60 * hour) + min); //총 주차 시간 update
            } 
            else {
                time.put(tmp[1], tmp[0]);
            }
        }
        //출차를 안한 경우(IN하고 안한 경우 23:59까지만 계산)
        if (!time.isEmpty()) {
            for (String s : time.keySet()) {
                String[] tmp = time.get(s).split(":");
                int hour = 23 - Integer.parseInt(tmp[0]);
                int min = 59 - Integer.parseInt(tmp[1]);
                money.put(s, money.get(s) + (hour * 60) + min);
            }
        }
        //차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 담아 return
        var a = new ArrayList<>(money.keySet());
        Collections.sort(a);

        //fees[0]=기본 시간, fees[1]=기본 요금, fees[2]=단위 시간(분), fees[3]=단위 요금
        //주차 요금: 기본요금+Math.ceil((누적 주차 시간- 180)/단위 시간) x 단위 요금
        //누적 주차 시간이 기본 시간 이하면 기본 요금

        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {

            int total_time = money.get(a.get(i));
            if (total_time <= fees[0]) {
                answer[i] = fees[1];
            }
            else{
                answer[i] = fees[1] + (int)Math.ceil((total_time - fees[0]) / (double) fees[2]) * fees[3];
            }
        }
        return answer;
    }
}
