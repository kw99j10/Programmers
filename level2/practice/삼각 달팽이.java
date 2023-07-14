class Solution {
    public int[] solution(int n) {
        
        int []answer=new int[(n*(n+1))/2]; //최댓값, 배열에 들어갈 값의 범위
        
        int[][] k = new int[n][n]; //이차원 배열의 크기 n*n

        int x=-1; //해당 값의 위치를 x,y좌표로 본다.
        int y=0;
        int count=1;
        for (int i=0;i<k.length;i++){
            for (int j=i;j<k.length;j++){

                if (i%3==0){
                    x+=1; //세로로 내려갈 때
                }
                else if (i%3==1){
                    y+=1; //가로로 증가할 때
                }
                else{
                    x-=1; //대각선으로 감소할 때
                    y-=1;
                }
                k[x][y]=count;
                count+=1;
            }
        }
        int tmp=0;
        for (int[] ints : k) {
            for (int t = 0; t < k.length; t++) {
                if (ints[t] == 0) {
                    break;
                }
                answer[tmp] = ints[t];
                tmp+=1;
            }
        }
        return answer;
    }
}
