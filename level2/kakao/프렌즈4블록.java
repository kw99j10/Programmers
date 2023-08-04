class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        String [][]tmp=new String[m][n]; //board 배열을 2차원 배열로 변환
        
        for(int i=0;i<tmp.length;i++){       
            String []s=board[i].split("");
            for(int j=0;j<tmp[i].length;j++){
                tmp[i][j]=s[j];
            }
        }
        
        while(true){
            int [][]num=new int[m][n]; //변환한 2차원 배열에 따른 2x2 값을 저장하기 위한 배열
            boolean b=false;
            
            //2x2 블록 체크하기
            for(int i=0;i<tmp.length-1;i++){
                for(int j=0;j<tmp[i].length-1;j++){
      
                    if(tmp[i][j].equals(tmp[i][j+1]) && tmp[i][j+1].equals(tmp[i+1][j]) &&
                      tmp[i+1][j].equals(tmp[i+1][j+1]) && !tmp[i+1][j+1].equals(" ")){
                        num[i][j]=1;
                        num[i][j+1]=1;
                        num[i+1][j]=1;
                        num[i+1][j+1]=1;
                        b=true;
                    }
                }
            }
            if(!b){
                break; // false이면 2x2 블록이 존재하지 않으므로 반복문 종료
            }
            
            //2x2 블록 제거하기
            for(int i=0;i<tmp.length;i++){
                for(int j=0;j<tmp[i].length;j++){
                    if(num[i][j]==1){
                        tmp[i][j]=" ";
                        answer+=1;
                    }
                }
            }
            //블록 떨어뜨리기
            for(int i=0;i<tmp.length;i++){
                for(int j=0;j<tmp[i].length;j++){
                    if(tmp[i][j].equals(" ")){
                        for(int k=i;k>0;k--){
                            if(tmp[k-1][j].equals(" ")){
                                break;
                            }
                            tmp[k][j]=tmp[k-1][j];
                            tmp[k-1][j]=" ";
                        }
                    }
                }
            }
        }
        return answer;
    }
}
