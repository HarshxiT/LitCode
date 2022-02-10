class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a1=version1.split("\\.");
        String[] a2=version2.split("\\.");
        int i=0;
        int j=0;
        // for(String s:a2)System.out.println(s);
        while(i<a1.length || j<a2.length){
            int n1=0;
            int n2=0;
            if(i<a1.length)
             n1=Integer.parseInt(a1[i]);
            if(j<a2.length)
             n2=Integer.parseInt(a2[j]);
            // System.out.println(n1+" "+n2);
            if(n1<n2)return -1;
            else if(n2<n1)return 1;
            i++;
            j++;
        }
        return 0;
        
        


    }
}