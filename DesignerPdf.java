static int designerPdfViewer(int[] h, String word) {
        char arr[] = new char[word.length()];
        arr = word.toCharArray();
        int max=0;
        for(int i=0;i<arr.length-1;i++){
            char ch = arr[i];
            if(h[ch-'a']>max) max=h[ch-'a'];
        }
        return word.length()*max;
    }
