function minByKey(key, database) {
  let currentValue = database[0][key] || 0;
  let currentMinObject = database[0];
  //loop through array looking at each object to see if it has that key
  for (var i=0; i<database.length; i++) {
    console.log(database[i])
    if(database[i][key]) {
      if(database[i][key] <= currentValue) {
        currentValue = database[i][key];
        currentMinObject = database[i];
      }
    } else {
      if(0 < currentValue) {
        currentValue = 0;
        currentMinObject = database[i];        
        console.log("BOO")
      }
    }   
  }
    //if it does, check to see if the value is lower than currentValue
  //after the loop, check if currentValue is falsey if so, deal with it, otherwise return the object associated with
  // if(!currentValue) {
  //   return {};
  // } else {
    return currentMinObject;
  // }
}
