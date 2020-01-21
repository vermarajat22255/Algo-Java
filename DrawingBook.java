if(n%2==0)
            return Math.min(p/2, (n+1-p)/2);
        else
            return Math.min(p/2, (n-p)/2);
//____________________________________________________

int count=0;
    if(p<= n/2)
    count = p/2;
    else
    count = n/2-p/2;
    return count;
