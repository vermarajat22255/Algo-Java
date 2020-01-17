let num="1";
let count=1,temp="";

if(num.length ==1) {
      console.log("1");
 }
for(let j=0;j<3;j++){
for(let i=1;i<=num.length;i++){
  
  if(num[i]==num[i-1]){
    count++;
  }
  else{
    temp = temp+''+ count+''+num[i-1];
    count=1;
  }
}
console.log(temp);
num=temp.trim();
temp="";
console.log("");
}
