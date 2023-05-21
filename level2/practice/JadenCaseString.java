class Solution {
    public String solution(String s) {
        StringBuilder sb=new StringBuilder();
        String []st=s.split(" ");
        for (int i=0;i<st.length;i++){

            if (st[i].length()==0)
                sb.append(" ");

            else
                sb.append(st[i].substring(0, 1).toUpperCase()).append(st[i].substring(1).toLowerCase()).append(" ");
        }
         
        //마지막 부분 문자열이 공백으로 올 경우의 수를 생각해야 함
         if (s.endsWith(" "))
            return sb.toString();
        else
            return sb.substring(0,sb.length()-1);
    }
}
