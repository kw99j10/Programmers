class Solution {
    public static StringBuilder sb = new StringBuilder(); //stringbuilder를 이용하여 (x,y)형식으로 저장
    public int[][] solution(int n) {
        
        hanoi(n,1,3,2); //하노이탑 알고리즘(주어진 수,시작 기둥, 목적지 기둥, 경유지 기둥)
        String [] st=sb.toString().split("\n");
        int [][]answer=new int[(int)Math.pow(2,n)-1][2]; //배열의 크기는 2의n승-1
        for (int i=0;i<st.length;i++){
            String[] k=st[i].split(" ");
            answer[i][0]= Integer.parseInt(k[0]);
            answer[i][1]= Integer.parseInt(k[1]);
        }
        return answer;
    }
    
    static void hanoi(int n,int a,int k,int b){ //(n,1,3,2)
        
        if(n==1){
            sb.append(a).append(" ").append(k).append("\n");
        }
        else{
            hanoi(n-1,a,b,k); //(n-1,1,2,3)
            sb.append(a).append(" ").append(k).append("\n");
            hanoi(n-1,b,k,a); //(n-1,2,3,1)
        }
    }
}
