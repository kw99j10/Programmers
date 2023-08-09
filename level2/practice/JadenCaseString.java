class Solution {
    public String solution(String s) {
        
        StringBuilder sb=new StringBuilder();
        String []st=s.split(" ");
        
        for (int i=0;i<st.length;i++){

            if (st[i].length()==0) == (st[i].equals("")
                sb.append(" "); => 공백으로 나누었을 때 그 길이가 0: 공백이 연속해서 나온 것으로 그 길이가 0이므로 " "(공백)을 stringBuilder에 더함

            else
                sb.append(st[i].substring(0, 1).toUpperCase()).append(st[i].substring(1).toLowerCase()).append(" "); //일반적인 경우 첫 글자를 대문자로, 아닐 경우 소문자로 변환
        }
         
        //마지막 부분 문자열이 공백으로 올 경우의 수를 생각해야 함
         if (s.endsWith(" "))
            return sb.toString();
        else
            return sb.substring(0,sb.length()-1);
    }
}
