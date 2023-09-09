class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        
        String [][]music=new String[musicinfos.length][musicinfos[0].length()];
        
        
        //시작 시각, 끝난 시각, 음악 제목, 악보 정보로 구분하여 배열에 저장
        for(int i=0;i<music.length;i++){
            String []tmp=musicinfos[i].split(",");
            music[i][0]=tmp[0];
            music[i][1]=tmp[1];
            music[i][2]=tmp[2];
            music[i][3]=tmp[3];
            
            //악보 정보의 # 문자 치환 C->c : 대문자->소문자 (도,레,미,파,솔,라,시)
            music[i][3]=music[i][3].replace("C#","c");
            music[i][3]=music[i][3].replace("D#","d");
            music[i][3]=music[i][3].replace("E#","F");
            music[i][3]=music[i][3].replace("F#","f");
            music[i][3]=music[i][3].replace("G#","g");
            music[i][3]=music[i][3].replace("A#","a");
            music[i][3]=music[i][3].replace("B#","C");
        }
        
        //네오가 기억한 문자열 m의  '#' 문자 치환 C->c : 대문자->소문자   
        m=m.replace("C#","c");
        m=m.replace("D#","d");
        m=m.replace("E#","F");
        m=m.replace("F#","f");
        m=m.replace("G#","g");
        m=m.replace("A#","a");
        m=m.replace("B#","C");
        
        int max=0; //제일 긴 음악 제목
             
        for(int i=0;i<music.length;i++){
            
            String []tmp1=music[i][0].split(":"); //시작 시간
            String []tmp2=music[i][1].split(":"); //종료 시간
            
            int start_hour=Integer.parseInt(tmp1[0]);
            int start_min=Integer.parseInt(tmp1[1]);
            
            int end_hour=Integer.parseInt(tmp2[0]);
            int end_min=Integer.parseInt(tmp2[1]);
            
            int hour=end_hour-start_hour;
            int min;
            
            if(start_min>end_min){
                min=60-Math.abs(start_min-end_min);
                hour-=1;
            }
            else{
                min=end_min-start_min;
            }
            int total_time=60*hour+min; //음악이 재생되는 시간
            
            String tmp=""; //재생되는 동안의 악보(누적)
            
            String title=music[i][2]; //음악 제목
            int length=music[i][3].length(); //악보 정보
            
            int k=0;
            int j=total_time;
            
            while(true){
                if(j==0){
                    break;
                }
                if(k==length){
                    k=0;
                }
                tmp+=music[i][3].charAt(k);
                k+=1;
                j-=1;
            }
            //System.out.println(tm+" "+tmp);
            
            if(tmp.contains(m)){
                
                if(total_time>max){
                    max=total_time;
                    answer=title;
                }
            }
        }
        return answer;
    }
}
