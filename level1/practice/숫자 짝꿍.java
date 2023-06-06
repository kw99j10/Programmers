class Solution {
    public String solution(String x, String y) {
      
        // "+" 연산으로 문자열을 더할 시 런타임 에러 발생 (String -> StringBuilder)
        StringBuilder answer= new StringBuilder();
       
        //0~9까지 문자열에서 추출한 숫자의 빈도(개수)
        int []count=new int[10];
        int []count1=new int[10];
        int []count2=new int[10];

        for(int i=0;i<count1.length;i++){
            for(int j=0;j<x.length();j++){
                if(Integer.parseInt(String.valueOf(x.charAt(j)))==i){
                    count1[i]+=1;
                }
            }
        }
        for(int i=0;i<count2.length;i++){
            for(int j=0;j<y.length();j++){
                if(Integer.parseInt(String.valueOf(y.charAt(j)))==i){
                    count2[i]+=1;
                }
            }
        }
        //두 숫자가 0이 아니라면 더 적은 빈도를 count 함
        //ex) 문자열 x에 2가 3개 y에 2가 2개 있다면 2를 count에 담음
        for(int i=0;i<count.length;i++){
            if(count1[i]!=0 && count2[i]!=0){
                count[i]=Math.min(count1[i],count2[i]);
            }
        }
        //짝꿍 유무 판단 변수(없으면 -1)
        boolean k=false;
      
        //만들 수 있는 가장 큰 정수를 구하는 문제이므로 역순으로 for문
        for(int i=count.length-1;i>=0;i--){

            if(count[i]!=0){
                k=true;

                int p=count[i];
                
                while (p != 0) {
                    answer.append(i);
                    p -= 1;
                }
            }
        }
        if(!k){
            answer = new StringBuilder("-1");
        }
        //문자열이 0으로 이루어질 경우 ex)"000" -> "0"
        if(answer.toString().startsWith("0")){
            answer = new StringBuilder("0");
        }
        return answer.toString();
    }
}
