class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
      
        //발음할 수 있는 단어 4개
        String []st={"aya","ye","woo","ma"};

        for(int i=0;i<babbling.length;i++){
            String p=babbling[i];
          
            //연속해서 발음할 경우는 제외
            if(p.contains(st[1]+st[1])||p.contains(st[0]+st[0])||p.contains(st[2]+st[2])||p.contains(st[3]+st[3])){
                continue;
            }
          
            //단어에서 발음할 수 있는 단어들을 모두 공백 (" ")으로 대체함
            //cf) ""(X)->" "(O) 반례: ex) myea -> 'ye'를 찾아서 지운 후 ""으로 대체할 경우 ma가 남게 됨. 따라서 이를 방지하기 위해 " "을 사용
            p=p.replace(st[0]," ");
            p=p.replace(st[1]," ");
            p=p.replace(st[2]," ");
            p=p.replace(st[3]," ");
            p=p.replace(" ","");
          
            //단어의 길이가 0이면 모두 발음한 
            if(p.equals("")){
                answer+=1;
            }
        }
        return answer;
    }
}
