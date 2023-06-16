import java.util.*;
class Solution {
    public int[] solution(String s) {
      
        //숫자를 제외한 문자  '{', '}', ',' 제거
        s=s.replaceAll(","," ");
        s=s.replaceAll("}","");
        s=s.replaceAll("\\{","");
        String []st=s.split(" ");

        var h = new HashMap<Integer, Integer>();

        for (String value : st) {
            int c = Integer.parseInt(value);
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        //key 빈도에 따른 value 내림차순 정렬
        var a= new ArrayList<>(h.keySet());
        Collections.sort(a,(o1,o2)->h.get(o2).compareTo(h.get(o1)));
        int []answer=new int[a.size()];
        int j=0;
        for (Integer integer : a) {
            answer[j]=integer;
            j+=1;
        }
        
        return answer;
    }
}
