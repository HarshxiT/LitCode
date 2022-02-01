class Solution {
    

    public int trap(int[] height) {
        int[] l=new int[height.length];
        int[] r=new int[height.length];
        l[0]=height[0];
        r[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++){
            l[i]=Math.max(height[i],l[i-1]);
            r[height.length-1-i]=Math.max(height[height.length-1-i],r[height.length-i]);
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            int m=Math.min(l[i],r[i]);
            ans+=(m-height[i]);
        }
        return ans;
    }
}