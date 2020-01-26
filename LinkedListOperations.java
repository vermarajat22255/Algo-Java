// At the end

 static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        SinglyLinkedListNode ptr = head;
        if(ptr == null) return node;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        ptr.next = node; 
        return head;
    }

//At the front 

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = llist;
        llist = node;
        return llist;
    }

// At position
static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        int i=1;
        SinglyLinkedListNode cpy = head;
        while(i<position){
            cpy = cpy.next;
            i++;
        }
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = cpy.next;
        cpy.next  = node;
        return head;
    }

// delete
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        int i=0;
        SinglyLinkedListNode ptr=head,copy=head;
        if(position == 0){
            return head = head.next;
        }
        while(i<position){
            ptr = copy;
            copy = copy.next;
            i++;
        }
        if(copy.next == null)
        {
            ptr.next = null;
        }else{
            ptr.next = copy.next;
        }
        System.out.println(head.data);
        return head;

    }

// Reverse print using recursion
static void reversePrint(SinglyLinkedListNode head) {
        
    if(head!=null){
        reversePrint(head.next);
        System.out.println(head.data);
    }
    }

//ACTUALLY REVERSE THE POINTERS OF LINKED LIST
static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode current =head,prev = null,next = head;
        if(current == null || current.next == null) return head;
        while(current != null ){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

// Compare Linked List
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1 != null && head2 != null && head1.data == head2.data){
            head1 = head1.next;
            head2 = head2.next;
        }
        if( head1 == null && head2 == null) return true;
        else if((head1 != null && head2 == null) || (head2 != null && head1 == null)||(head1.data != head2.data))
        return false;
            
        return true;
    }

// Merge two sorted List
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode ptr1 = head1,ptr2 = head2;
        SinglyLinkedListNode head  = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode ne = head;
        if(ptr2 == null && ptr1 != null ) return ptr1;
        if(ptr2 != null && ptr1 == null ) return ptr2;
        
        while(ptr2 != null && ptr1 != null){
            if( ptr2 != null && ptr1.data >= ptr2.data){
                head.next = ptr2;
                ptr2 = ptr2.next;
            }
            else if(ptr1 != null && ptr2.data > ptr1.data){
                head.next = ptr1;
                ptr1 = ptr1.next;
            }
            head  = head.next;
        }
        if(ptr1 == null && ptr2 != null){
            head.next = ptr2;
            }
        else if(ptr2 == null && ptr1 != null){
              head.next = ptr1;
            } 
    return ne.next;
    }

// Get Nth Node from tail
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode ptr = head;
        int i=0;
        while(ptr.next!=null){ 
            ptr = ptr.next;
            i++;
        }
        i = i - positionFromTail;
        while(i>0){
            head = head.next;
            i--;
        }
        return head.data;

    }
// MERGE TWO Linked list from same Node

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int l1 = 0,l2=0,res =-1;
        SinglyLinkedListNode ptr1=head1,ptr2 = head2,mark1 =head1,mark2 =head2;
        while(ptr1!=null){
            ptr1 = ptr1.next;
            l1++;
        }
        while(ptr2!=null){
            ptr2 = ptr2.next;
            l2++;
        }
        int remain = 0;
        ptr1=head1;ptr2 = head2;
        if(l1>l2){
            remain = l1-l2;
            mark1 = ptr1;
            mark2 = ptr2;
        }else{
            remain = l2-l1;
            mark1 = ptr2;
            mark2 = ptr1;
        }
        while(remain>0){
            mark1 = mark1.next;
            remain--;
        }
        while(mark1!=null){
            if(mark1!=mark2){
                mark1 = mark1.next;
                mark2 = mark2.next;
            }
            else{
                res = mark1.data;
                break;
            }
        }
        return res;
    }
