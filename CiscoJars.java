public class CiscoJars {
    public static void main(String args[]) {
        // 5 78 90 80 10 -- 158
        int jars[] = new int[] { 5, 30, 99, 60, 5, 10 }; // 114 -- 5, 99, 10

        int arr[] = new int[]{5, 5, 10, 100, 10, 5}; 
        if (jars.length == 1) {
			return jars[0];
		}

        System.out.println(FindMaxSum(jars, jars.length));
    }

    static int maxSumSeq(int[] A)
	{
		int back = A[0];

		int prev = Integer.max(A[0], A[1]);
        int i=2;
		while ( i < A.length)
		{
			int curr = Integer.max(A[i], Integer.max(prev, back + A[i]));
			back = prev;
            prev = curr;
            i++;
		}

		return prev;
	}
}