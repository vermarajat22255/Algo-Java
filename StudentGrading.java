public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    for(int i=0;i<grades.size();i++){
        if(grades.get(i)>=38 && grades.get(i)%5!=0){
            int temp = (grades.get(i)+1)%5 == 0?grades.get(i)+1:(grades.get(i)+2)%5==0?grades.get(i)+2:grades.get(i);

            grades.set(i,temp);
        }
    }
    return grades;
    }
