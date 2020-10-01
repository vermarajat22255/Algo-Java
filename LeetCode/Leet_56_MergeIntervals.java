class Leet_56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        result.add(intervals[0]);
        int j=0;
        for(int i=1; i<intervals.length; i++){
            if(result.get(j)[1] >= intervals[i][0] ){
                result.get(j)[1] = Math.max(result.get(j)[1], intervals[i][1]);
            }else{
                result.add(intervals[i]);
                j++;
            }
        }
        // System.out.println(Arrays.toString(result));
        return result.toArray(new int[result.size()][]);
    }
}
