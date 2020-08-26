
public class Leet28_strStr {
    public int strStr(String haystack, String needle) {
        if (needle == "")
            return 0;

        if (!haystack.contains(needle))
            return -1;

        return haystack.indexOf(needle);
    }

}