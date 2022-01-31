class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // String[] ans=new String[logs.length];
        
        Arrays.sort(logs,(a,b)->{
            int s1=a.indexOf(' ');
            int s2=b.indexOf(' ');
            if(a.charAt(s1+1)<='9'){
                if(b.charAt(s2+1)<='9')return 0;
                return 1;
            }
            if(b.charAt(s2+1)<='9')return -1;
            int t=a.substring(s1+1).compareTo(b.substring(s2+1));
            if(t!=0)return t;
            return a.substring(0,s1).compareTo(b.substring(0,s2));
        });
        return logs;
    }
}