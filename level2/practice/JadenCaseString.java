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
            
         if (s.endsWith(" "))
            return sb.toString();
        else
            return sb.substring(0,sb.length()-1);
    }
}
