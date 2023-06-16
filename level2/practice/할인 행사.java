import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        var a=new ArrayList<String>();
        
        //수량 만큼 리스트에 해당 제품을 넣으면 됨
        for(int i=0;i<want.length;i++){
            for(int j=0;j<number[i];j++){
                a.add(want[i]);
            }
        }

        for (int i=0;i<=discount.length-10;i++){
            
            //10일 동안 제품과 수량이 일치해야 하므로 10일의 범위만큼 discount 배열을 쪼개서 만듦
            var at=new ArrayList<>(Arrays.asList(Arrays.copyOfRange(discount, i, i + 10)));

            //리스트에 해당 제품이 있다면 copy배열에서 해당 제품을 제거
            for (String s : a) {
                at.remove(s);
            }
            
            //비어 있다면 문제 조건을 만족(10일 동안 제품과 수량이 일치)
            if (at.isEmpty()){
                answer+=1;
            }
        }
        return answer;
    }
}
