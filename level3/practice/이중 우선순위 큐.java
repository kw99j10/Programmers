import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
      
        var h1=new PriorityQueue<Integer>(); //우선순위 큐- 오름차순 정렬
       
        for(int i=0;i<operations.length;i++){
            String[] k = operations[i].split(" ");
            if(k[0].equals("I")){
                h1.add(Integer.parseInt(k[1]));
            }
            else if(k[0].equals("D")){
                if(h1.isEmpty()){
                    continue;
                }
                if(k[1].equals("1")){
                    Integer[] array = h1.toArray(new Integer[0]); //최댓값을 삭제하는 경우 배열로 변환하여 마지막 index를 구하여 이를 삭제
                    int lastIndex = array.length - 1;
                    int lastElement = array[lastIndex];
                    h1.remove(lastElement);
                }
                else{
                    h1.poll(); //최솟값은 맨 앞 요소를 삭제
                }
            }
        }
        int []answer=new int[2];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        if(h1.size()==0){
            min=max=0; //힙의 사이즈가 0이면 max=0, min=0
        }
        for (Integer integer : h1) {
            max=Math.max(max,integer);
            min=Math.min(min,integer);
        }
        answer[0]=max;
        answer[1]=min;
        return answer;
    }
}
