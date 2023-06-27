class Solution {
    public int[] solution(int N, int[] stages) {
      
        //스테이지의 개수 & 해당 스테이지의 실패율을 담는 배열
        int[] answer = new int[N];
        double []ans=new double[N];

         int stage_count=stages.length;
          for(int i=0;i<answer.length;i++){
            int count=0;


            for(int j=0;j<stages.length;j++){
                if(stages[j]==i+1){
                    count+=1;
                }
            }
            
            //실패율: (해당 단계에 실패한 수) / (단계별로 넘어갈 때마다 이 전 단계에서 실패한 수(count)를 감소한 값)
            ans[i]= (double)count/stage_count;
            answer[i]=i+1;
            stage_count-=count;
        }
      
        //실패율이 높은 순서로 정렬
        for (int i=0;i<ans.length;i++){

            double tmp;
            int k;

            for (int j=i+1;j<ans.length;j++){

                if (ans[j]>ans[i]){
                    tmp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=tmp;

                    k=answer[i];
                    answer[i]=answer[j];
                    answer[j]=k;
                }
            }

        //실패율이 같다면 index 오름차순 정렬
            int p;
            for (int j=i+1;j<answer.length;j++){
                if (ans[j]==ans[i]){
                    if (answer[i]>answer[j]){
                        p=answer[i];
                        answer[i]=answer[j];
                        answer[j]=p;
                    }
                }
            }
        }  
        return answer;
    }
}
