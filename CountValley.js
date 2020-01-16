// Complete the countingValleys function below.
function countingValleys(n, s) {
let path = s.split("");
let sum=0,valley=false,num=0;
for(let i =0;i<path.length;i++){
    let temp = path[i]=='U'?1:-1;
    sum = sum +temp;
    if(sum<0 && !valley){
        valley=true;
        num++;
    }
    if(sum>=0) valley=false;
}
return num;

}
