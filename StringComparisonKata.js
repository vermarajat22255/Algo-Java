s1 = "my&friend&Paul has heavy hats! &";
s2 = "my friend John has many many friends &";
let res1={},res2 = {},final={};
let s = new Set();
for(let i=0;i<s1.length;i++){
  if(s1[i]>='a' && s1[i]<='z'){
  if(res1[s1[i]]) 
    ++res1[s1[i]];
  else res1[s1[i]]=1;
  s.add(s1[i]);
  }
}
for(let i=0;i<s2.length;i++){
  if(s2[i]>='a' && s2[i]<='z'){
  
  if(res2[s2[i]]) ++res2[s2[i]];
  else res2[s2[i]]=1;
  
  s.add(s2[i]);
  }
}
//  console.log(res1);
//  console.log(res2);
let values=s.keys();
for(let i=0;i<s.size;i++){
  let temp = values.next().value;
  if(res1[temp]>res2[temp] && (res1[temp]>1 || res2[temp]>1)){
  final[temp] = res1[temp];
  }
  else if(res1[temp]<res2[temp] && res1[temp]>1 || res2[temp]>2){
  final[temp]=res2[temp];
  }
}
console.log(final);
