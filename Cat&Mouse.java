    static String catAndMouse(int x, int y, int z) {
        int xM = z-x<0?x-z:z-x;
        int yM = z-y<0?y-z:z-y;
        String s ="Mouse C";
        if(xM<yM) return "Cat A";
        else if(xM>yM) return "Cat B";
    return s;
    }
