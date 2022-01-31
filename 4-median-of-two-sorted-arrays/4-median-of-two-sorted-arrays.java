class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ar=merge(nums1,nums2);
        if(ar.length%2==1){
            return (double)ar[ar.length/2];
        }
        else{
            double a=(double)ar[ar.length/2];
            double b=(double)ar[(ar.length/2) - 1];
            return (a+b)/2;
        }
    }
    public int[] merge(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        int[] ar=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ar[k]=nums1[i];
                i++;
            }
            else{
                ar[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            ar[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            ar[k]=nums2[j];
            j++;
            k++;
        }
        return ar;
    }
}