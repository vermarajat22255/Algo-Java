import java.util.ArrayList;
import java.util.List;

public class Leet_PascalTri {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return al;
        List<Integer> load1 = new ArrayList<>();
        List<Integer> load2 = new ArrayList<>();

        load1.add(1);
        al.add(load1);
        if (numRows == 1)
            return al;
        load2.add(1);
        load2.add(1);
        al.add(load2);
        if (numRows == 2)
            return al;

        int arr[] = { 1, 1 };
        ArrayList<Integer> temp = nextList(arr);

        for (int i = 3; i <= numRows; i++) {
            int tempArr[] = temp.stream().mapToInt(x -> x).toArray();
            al.add(temp);
            temp = nextList(tempArr);
        }
        System.out.println(al);
        return al;
    }

    public ArrayList<Integer> nextList(int arr[]) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        for (int i = 1; i < arr.length; i++) {
            al.add(arr[i - 1] + arr[i]);
        }
        al.add(1);
        return al;
    }
}