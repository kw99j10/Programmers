class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length==1){
            return sticker[0]; //길이가 1일 경우
        }
        if(sticker.length==2){
            return Math.max(sticker[1],sticker[0]);    
        }
        int []dp1=new int[sticker.length]; //0번째부터 시작할 경우
        int []dp2=new int[sticker.length]; //1번째부터 시작할 경우
        
        int []tmp=new int[sticker.length]; //1번째부터 시작한다면 처음 값은 선택하지 않으므로 한 칸씩 앞으로 이동
        for(int i=0;i<tmp.length-1;i++){
            tmp[i]=sticker[i+1];
        }

        //2칸 간격으로 스티커를 뗄 수 있으므로 배열 각각 0번째, 1번째 배열 값 초기화
        dp1[0]=sticker[0];
        dp1[1]=Math.max(dp1[0],sticker[1]);
        
        for(int i=2;i<sticker.length-1;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
        }
        dp1[dp1.length-1]=dp1[dp1.length-2]; //0번째(처음)부터 시작하면 마지막 스티커를 뗄 수 없으므로 마지막 항은 이 전 값과 같다.
        
        dp2[0]=sticker[1];
        dp2[1]=Math.max(dp2[0],sticker[2]);
        
        for(int i=2;i<sticker.length;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+tmp[i]);
        }

        answer=Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
        return answer;
    }
}
