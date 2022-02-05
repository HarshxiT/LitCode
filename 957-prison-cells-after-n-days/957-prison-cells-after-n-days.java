class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashMap<String,Integer>map=new HashMap<>();
        while(n>0){
            int[] nc=new int[cells.length];
            System.out.println(Arrays.toString(cells));
            map.put(Arrays.toString(cells),n--);
            for(int i=1;i<cells.length-1;i++){
                if(cells[i-1]==cells[i+1])nc[i]=1;
            }
            cells=nc;
            if(map.containsKey(Arrays.toString(cells))){
                System.out.println("found");
                n%=map.get(Arrays.toString(cells))-n;
            }
            map.put(Arrays.toString(cells),n);
        }
        return cells;
    }
}