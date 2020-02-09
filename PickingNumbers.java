    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
    Collections.sort(a);
    int i=1,count=0,max=0;
    int min = a.get(0);
    while(i<a.size()){
        if(a.get(i)-min<=1)
        ++count;
        else{
            min = a.get(i);
            if(max<count)max = count;
            count =0;
        }
        i++;
    }
    if(max<count)max = count;
    return max==0?0:max+1;
    }

}
