/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;

class Leet2_AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger result = getNumber(l1).add(getNumber(l2));
        System.out.print(getNumber(l1) +" and "+ getNumber(l2) +"="+ result);
        
        ListNode l = new ListNode(0);
        
        ListNode pointer = l;   //Copy
        if(result.intValue() == 0) return l;
        BigInteger zero = new BigInteger("0");
        while(result.compareTo(zero) != 0){
            l.next = new ListNode((result.mod(new BigInteger("10"))).intValue());
            result = result.divide(new BigInteger("10"));
            l = l.next;
        }
        return pointer.next;
    }
    static BigInteger getNumber(ListNode l){
        String s="";
        while(l != null){
            s = s+l.val;
            l = l.next;
        }
        return new BigInteger(new StringBuilder(s).reverse().toString());
    }
}