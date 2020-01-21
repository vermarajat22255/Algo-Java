// Complete the commonChild function below.
    static int count=0;
    static int commonChild(String s1, String s2) {
        return dynamic(s1,s2);
    }

    static int dynamic(String s1,String s2){
        int c[][] = new int[s1.length()+1][s1.length()+1];
        char b[][] = new char[s1.length()+1][s1.length()+1];
        
        char a1[] = new char[s1.length()]; 
        a1 = s1.toCharArray();
        char a2[] = new char[s2.length()]; 
        a2 = s2.toCharArray();
        
        for(int i=0;i<=a1.length;i++){
            c[0][i] = 0;
            c[i][0] = 0;
        }
        for(int i=1;i<=a1.length;i++){
            for(int j=1;j<=a1.length;j++){
                if(a1[i-1]==a2[j-1]){
                    c[i][j] +=c[i-1][j-1]+1;
                    b[i][j] = 'D'; //diagonal
                }
                else if(c[i-1][j]>=c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j] = 'U';//up
                    }
                else{
                        c[i][j] = c[i][j-1];
                        b[i][j] = 'L'; //left
                }
                System.out.print(b[i][j]+" ");
            }

                System.out.println("");
        }

        return print(b,a1.length,a2.length);
    }
    static int print(char b[][],int i,int j){
        if(i==0 && j==0) return 0;
        if(b[i][j] == 'D') {
            count++;
            print(b,i-1,j-1);
        }else{
            if(b[i][j] == 'U'){
                print(b,i-1,j);
            }
            else{
                print(b,i,j-1);
            }
        }
        return count;
    }
