class Solution {
    public int k1d(int[] nums){
        int i=-1;
        int j=-1;
        int ans=0;
        HashMap<Integer,Integer> b=new HashMap<>();
        while(true){
            boolean f1=false;
            boolean f2=false;
            while(i<nums.length-1){
                f1=true;
                i++;
                b.put(nums[i],b.getOrDefault(nums[i],0)+1);
                if(b.keySet().size()>1){
                    b.remove(nums[i]);
                    i--;
                    break;
                }
            }
            while(j<i){
                ans+=i-j;
                f2=true;
                j++;
                b.put(nums[j],b.get(nums[j])-1);
                if(b.get(nums[j])==0){
                    b.remove(nums[j]);
                }
                if(b.keySet().size()<1) break;
            }
            if(f1==false && f2==false ){
                break;
            }
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k==1){
            return k1d(nums);
        }
        int count=0;
        HashMap<Integer,Integer> b=new HashMap<>();
        HashMap<Integer,Integer> s=new HashMap<>();
        
        int i=-1;
        int is=-1;

        int j=-1;
        while(true){
            boolean f1=false;
            boolean f2=false;
            boolean f3=false;

            while(i<nums.length-1){
                f1=true;
                i++;
                b.put(nums[i],b.getOrDefault(nums[i],0)+1);
                if(b.keySet().size()>k){
                    b.remove(nums[i]);
                    i--;
                    break;
                }
            }
            while(is<i){
                f2=true;
                is++;
                s.put(nums[is],s.getOrDefault(nums[is],0)+1);
                // if(s.keySet().size()==k){
                //     count++;
                // }
                if(s.keySet().size()>k-1){
                    s.remove(nums[is]);
                    is--;
                    break;
                }
            }
            while(j<is){
                f3=true;
                if(s.keySet().size()==k-1 && b.keySet().size()==k){
                    count+=i-is;
                }
                j++;
                b.put(nums[j],b.get(nums[j])-1);
                if(b.get(nums[j])==0){
                    b.remove(nums[j]);
                }
                s.put(nums[j],s.get(nums[j])-1);
                if(s.get(nums[j])==0){
                    s.remove(nums[j]);
                }
                if(s.keySet().size()<k-1 || b.keySet().size()<k) break;
            }
            if(f1==false && f2==false && f3==false){
                break;
            }
        }
        return count;
    }
}